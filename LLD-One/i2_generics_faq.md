# Java Generics Interview FAQ

## 1. What's the difference between `? extends T` and `? super T`?

### `? extends T` (Upper Bound Wildcard)
Means "a type that is T or any subtype of T." You can only **read** from such a collection safely.

```java
// Example: Animal hierarchy
class Animal { }
class Dog extends Animal { }
class Cat extends Animal { }

// This method accepts List of Animal or any subclass of Animal
public static void printAnimals(List<? extends Animal> animals) {
    for (Animal animal : animals) {
        System.out.println(animal);  // Safe to read
    }
}

// Usage
List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
List<Animal> animals = Arrays.asList(new Animal(), new Dog());

printAnimals(dogs);      // ✓ Works
printAnimals(animals);   // ✓ Works

// But you CANNOT add to it:
// animals.add(new Dog());  // ✗ Compile-time error!
// Why? Because the actual list could be List<Cat>, and adding a Dog would be unsafe.
```

**Key Point:** Use `extends` when you want to **read from** a collection (consumer pattern).

---

### `? super T` (Lower Bound Wildcard)
Means "a type that is T or any supertype of T." You can only **write to** such a collection safely.

```java
// This method accepts List of Animal or any superclass of Animal
public static void addDogs(List<? super Dog> list) {
    list.add(new Dog());  // Safe to write
}

// Usage
List<Dog> dogList = new ArrayList<>();
List<Animal> animalList = new ArrayList<>();
List<Object> objectList = new ArrayList<>();

addDogs(dogList);     // ✓ Works
addDogs(animalList);  // ✓ Works (Animal is superclass of Dog)
addDogs(objectList);  // ✓ Works (Object is superclass of Dog)

// But you CANNOT read from it safely:
// Dog dog = list.get(0);  // ✗ Compile-time error!
// Why? Because you could be getting an Animal or Object, not necessarily a Dog.
```

**Key Point:** Use `super` when you want to **write to** a collection (producer pattern).

---

### Memory Aid: PECS
**Producer Extends, Consumer Super**
- **Producer** (reading/output): use `? extends T`
- **Consumer** (writing/input): use `? super T`

---

## 2. How does Java prevent ClassCastException after Type Erasure?

This is a crucial question. Type erasure removes generic information at **runtime**, so how does Java prevent casting errors?

### The Answer: Implicit Type Casts at Compile Time

Java **inserts automatic type casts** during compilation wherever needed. The compiler does the heavy lifting, not the runtime.

```java
// Your code:
List<String> strings = new ArrayList<>();
strings.add("Hello");
String str = strings.get(0);  // No explicit cast needed

// What the compiler actually generates (after type erasure):
List strings = new ArrayList();
strings.add("Hello");
String str = (String) strings.get(0);  // Implicit cast inserted by compiler!
```

### Example: Where ClassCastException Would Still Occur

```java
// This bypasses generics (using raw types)
List rawList = new ArrayList();
rawList.add(42);  // Adding an Integer

// Trying to treat it as a String list
List<String> stringList = (List<String>) rawList;  // Compile warning only
String str = stringList.get(0);  // ClassCastException at runtime!
                                 // Because actual object is Integer, not String
```

The compiler inserts a cast expecting a String:
```java
String str = (String) stringList.get(0);  // ← compiler inserted this
// But actual value is 42 (Integer), so ClassCastException is thrown
```

### Key Points

1. **Generics are compile-time only:** Type information is erased at runtime
2. **ClassCastException can still happen** when:
   - You use raw types
   - You bypass generics with `@SuppressWarnings`
   - You have unsafe casting

3. **Prevention happens at compile time:** The compiler ensures type safety by:
   - Checking type parameters match constraints
   - Inserting implicit casts where needed
   - Preventing incompatible assignments

---

## 3. How are generics actually implemented under the hood?

### Type Erasure Process

```java
// Before erasure:
public class Box<T> {
    private T value;
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
}

// After erasure (what bytecode looks like):
public class Box {
    private Object value;  // T → Object
    
    public Object getValue() {
        return value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
}
```

### With Bounded Types

```java
// Before erasure:
public class NumberBox<T extends Number> {
    private T value;
    
    public T getValue() {
        return value;
    }
}

// After erasure:
public class NumberBox {
    private Number value;  // T → Number (upper bound)
    
    public Number getValue() {
        return value;
    }
}
```

---

## 4. What are Bridge Methods and why are they needed?

Bridge methods ensure polymorphism works correctly with generics.

```java
// Generic class
public class Box<T extends Number> {
    public T getValue() {
        return value;
    }
}

// Subclass that specializes the type
public class IntegerBox extends Box<Integer> {
    @Override
    public Integer getValue() {
        return value;
    }
}
```

After type erasure, `Box.getValue()` returns `Number`, but `IntegerBox.getValue()` returns `Integer`. The compiler generates a bridge method in `IntegerBox`:

```java
// Generated bridge method (synthetic)
public Number getValue() {
    return getValue();  // Calls the actual Integer-returning method
}
```

This maintains polymorphism and prevents `ClassCastException` when using references to the parent class.

---

## 5. When would type erasure cause problems?

### You Cannot Do This:

```java
// ✗ Cannot use instanceof with generics
if (list instanceof List<String>) { }  // Compile error

// ✗ Cannot create arrays of parameterized types
List<String>[] array = new List<String>[10];  // Compile error

// ✗ Cannot use type parameters in static contexts
public class Box<T> {
    static T instance;  // Compile error
}

// ✗ Cannot throw/catch generic exceptions
try {
    // ...
} catch (Exception<T> e) {  // Compile error
    // ...
}
```

### Why? Because `T` doesn't exist at runtime!

---

## 6. Raw Types vs Generics - Key Difference

```java
// Raw type (pre-generics code):
List list = new ArrayList();
list.add("Hello");
list.add(42);
String str = (String) list.get(1);  // ClassCastException!

// With generics:
List<String> list = new ArrayList<>();
list.add("Hello");
list.add(42);  // ✗ Compile-time error! Type safe.
String str = list.get(0);  // Safe, no explicit cast needed
```

**Raw types bypass compile-time checking and put responsibility on you.**

---

## 7. Interview Tips

**Common Interview Questions:**

1. **"What's the purpose of generics?"**
   - Compile-time type safety, avoid ClassCastException, code reusability

2. **"Does generics have runtime overhead?"**
   - No, type erasure ensures no runtime overhead compared to raw types

3. **"Can you have multiple bounds?"**
   - Yes: `<T extends Number & Comparable<T> & Serializable>`
   - Class must come first, then interfaces

4. **"What about variance?"**
   - Generics are **invariant** by default: `List<String>` is NOT a `List<Object>`
   - Use `extends` for covariance and `super` for contravariance

5. **"Give real-world examples of `extends` vs `super`"**
   - **Collections.copy()** uses both:
   ```java
   public static <T> void copy(List<? super T> dest, List<? extends T> src) {
       for (T item : src) {
           dest.add(item);  // src is producer (extends), dest is consumer (super)
       }
   }
   ```