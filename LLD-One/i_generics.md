# All about Generics
- [Generics](#all-about-generics)
    - [Generics](#generics)
        - [Generic methods](#generic-methods)
        - [Generic classes](#generic-classes)
        - [Bounded Type Parameters](#bounded-type-parameters)
        - [Wildcards](#wildcards)
        - [Additional reading](#additional-reading-1)
            - [Type Erasure](#type-erasure)
            - [Advantages of Type Erasure](#advantages-of-type-erasure)

## Generics

Generics were added to Java to provide compile-time type checking and removing the risk of ClassCastException that was common while working with collection classes. Before generics, we can store any type of objects in the collection, i.e., non-generic. Now generics force the java programmer to store a specific type of objects.

Generics allows us to reuse the same code with different inputs. We can use Java generics methods and classes for any type of objects. The idea is to allow type (Integer, String, … etc, and user-defined types) to be a parameter to methods, classes, and interfaces. For example, classes like HashSet, ArrayList, HashMap, etc use generics very well. We can use them for any type.

### Generic methods

We can write a single generic method declaration that can be called with arguments of different types. Based on the types of the arguments passed to the generic method, the compiler handles each method call appropriately. Following are the rules to define Generic Methods:
1. All generic method declarations have a type parameter section delimited by angle brackets (< and >) that precedes the method's return type.
2. Each type parameter section contains one or more type parameters separated by commas. A type parameter, also known as a type variable, is an identifier that specifies a generic type name.

Let us say we want to write a generic method that can print an integer, string or any other type. For this, we will use the following syntax:

```java
public static <T> void print(T t) {
    System.out.println(t);
}
```

Here, we have used the generic method print that can print any type of data. The type parameter is specified with the help of angle brackets. The type parameter section, delimited by angle brackets (< and >), follows the method name. It specifies the type parameters (also called type variables) T.

We can also use multiple type parameters in a generic method. For example:

```java
public static <T, U> void print(T t, U u) {
    System.out.println(t + " " + u);
}
```

### Generic classes

If multiple methods are using generics then we can create a generic class that can be used by all those methods. For example, we can create a generic class Pair that can store a key-value pair. We can use this class to store a pair of integers, a pair of strings, etc.

```java
public class Pair<L, R> {
    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }
}
```

Apart from reducing type declarations, generics also allow us to create generic fields and constructors.

### Bounded Type Parameters

We can also restrict the types that can be passed to a type parameter. For example, a method that works on numbers might only want to accept instances of Number or its subclasses. This is what bounded type parameters are for.

If we want to write a method that can print the details of any type of employee, we can use the following syntax:

```java
public static <T extends Employee> void print(T t) {
    System.out.println(t);
}
```

We can also use multiple bounds on a type parameter. For example:

```java
public static <T extends Employee & Comparable<T>> void print(T t) {
    System.out.println(t);
}
```

### Wildcards

The question mark (?) represents an unknown type. The wildcard can be used in a variety of situations such as the type of a parameter, field, or local variable; sometimes as a return type (though it is better programming practice to be more specific). The wildcard is never used as a type argument for a generic method invocation, a generic class instance creation, or a supertype.

For example, we can write a method that works on lists of any type:

```java
public static void printList(List<?> list) {
    for (Object elem: list)
        System.out.print(elem + " ");
    System.out.println();
}
```

### Additional reading

The implementation of generics in Java involves a concept known as type erasure, which allows the benefits of generics to be realized without introducing significant runtime overhead.

Here's how generics are implemented in Java:

1. **Type Erasure:**
    - Generics in Java use a mechanism called "type erasure" to ensure backward compatibility with pre-existing code and to minimize the runtime overhead introduced by introducing generics.
    - During compilation, the compiler replaces type parameters (e.g., `T`, `E`) with their corresponding bound types or with `Object` if no bounds are specified. This process is known as type erasure.
    - For example, a generic class `Box<T>` would be treated as `Box` at runtime after type erasure.

2. **Type Bounds:**
    - Generics allow you to specify upper and lower bounds for type parameters using wildcards (`? extends T` and `? super T`). These bounds are enforced at compile-time to ensure type safety.
    - Type bounds help restrict the types that can be used with a generic class or method, ensuring that only compatible types are used.

3. **Type Checking and Inference:**
    - The Java compiler performs extensive type checking during compilation to ensure that the usage of generics is correct and adheres to specified type bounds.
    - Type inference allows the compiler to automatically determine the appropriate type based on the context in which a generic type is used.

4. **Type Casting and Raw Types:**
    - Type erasure can lead to situations where type information is lost at runtime. To maintain compatibility with legacy code and libraries, Java allows the use of raw types, where generic type information is ignored. However, using raw types circumvents the benefits of type safety offered by generics.
    - Explicit type casting may be necessary when working with raw types or objects of unknown generic types.

5. **Bridge Methods:**
    - To ensure compatibility between generic and non-generic code, the compiler generates bridge methods during compilation. These bridge methods help maintain polymorphism and type safety.

Here's a simplified example to illustrate generics implementation:

```java
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(42);
        Box<String> stringBox = new Box<>("Hello");

        Integer intValue = integerBox.getValue();
        String stringValue = stringBox.getValue();

        System.out.println("Integer Value: " + intValue);
        System.out.println("String Value: " + stringValue);
    }
}
```

In this example, the generic class `Box<T>` is implemented. The type parameter `T` is replaced with its bound types during type erasure. The type safety and compile-time checking provided by generics ensure that only appropriate types are used with the `Box` class.

#### Type Erasure

Type erasure is a fundamental concept in Java's generics that allows the benefits of generics to be achieved at compile-time while minimizing the runtime overhead. It ensures compatibility with pre-existing non-generic code and prevents the creation of multiple versions of classes for each type parameter.

Let's delve into the steps that happen at compile-time and runtime when dealing with type erasure:

**Compile-Time Steps:**

1. **Declaration with Type Parameter:**
    - When you declare a generic class, interface, or method with a type parameter, such as `class Box<T>`, the type parameter `T` is used as a placeholder for a specific type.

2. **Type Checking and Constraints:**
    - The compiler performs type checking and enforces constraints specified by type bounds (`extends` and `super`) during compilation to ensure type safety.

3. **Type Erasure:**
    - After type checking, the compiler replaces all occurrences of the type parameter with its bound type or `Object` if no bounds are specified. This process is known as type erasure.
    - The actual type information associated with the type parameter is removed from the compiled bytecode.

4. **Bridge Methods Generation:**
    - To maintain compatibility between generic and non-generic code, the compiler generates bridge methods during compilation.
    - Bridge methods ensure polymorphism and type safety when overriding methods in subtypes.

**Runtime Steps:**

1. **Erased Types:**
    - At runtime, generic types are treated as their raw types due to type erasure. Raw types are classes or interfaces without type parameters.

2. **Type Casting and Type Checks:**
    - If you use a generic class or method with a specific type argument, the compiler inserts necessary type casts and checks to ensure type safety.

3. **Compatibility with Legacy Code:**
    - Type erasure allows generic code to interact seamlessly with pre-existing non-generic code and libraries.

Here's an example to illustrate type erasure:

```java
import java.util.List;

public class TypeErasureExample {
    public static void main(String[] args) {
        List<String> stringList = List.of("Hello", "World");
        List<Integer> integerList = List.of(42, 73);

        System.out.println("List Class for Strings: " + stringList.getClass());
        System.out.println("List Class for Integers: " + integerList.getClass());

        // Compile-time type checking prevents incorrect assignments
        // stringList = integerList; // Compile-time error
    }
}
```

In this example, the generic types `List<String>` and `List<Integer>` are treated as the raw type `List` at runtime due to type erasure. This is why `stringList.getClass()` and `integerList.getClass()` return the same `List` class at runtime.

Type erasure helps ensure that the compiled bytecode is compatible with pre-existing code and maintains type safety. It enables the use of generics while minimizing the impact on runtime performance. However, it's important to note that some type information is lost at runtime, and certain operations, such as reflection, may behave differently when dealing with generic types.

When referring to "specified type bounds and constraints" in the context of generics, we are talking about limitations and requirements that are defined for the types that can be used as arguments for a generic class, interface, or method. These bounds and constraints help ensure type safety and restrict the range of possible types that can be used with the generic construct.

Here are the key concepts related to specified type bounds and constraints:

1. **Type Bounds (extends and super):**
    - Generics allow you to specify bounds on the types that can be used as type arguments. These bounds define a range of acceptable types.
    - The `extends` keyword is used to specify an upper bound, indicating that the type argument must be a subtype of a certain class or interface.
    - The `super` keyword is used to specify a lower bound, indicating that the type argument must be a supertype of a certain class or interface.

```java
class Box<T extends Number> { ... } // T must be a subtype of Number
class Container<T super Integer> { ... } // T must be a supertype of Integer
```

2. **Constraints on Method Signatures:**
    - Generics can have constraints on method signatures within a generic class or interface.
    - Constraints can include rules about the relationship between the types of method parameters, return types, and type arguments.

```java
interface Processor<T extends Number> {
    double process(T value); // Constraint on method signature
}
```

3. **Type Compatibility and Inference:**
    - Specified bounds and constraints ensure that only compatible types can be used with the generic construct.
    - When using a generic class or method, the Java compiler enforces these constraints and ensures type compatibility.

```java
Box<Integer> intBox = new Box<>(42); // OK, Integer is a subtype of Number
Box<String> strBox = new Box<>("Hello"); // Compile-time error, String is not a subtype of Number
```

In summary, specified type bounds and constraints in generics define the allowable range of types that can be used with a generic construct. This helps prevent incorrect type usage, enhances type safety, and ensures that the generic code works with a limited set of compatible types.

#### Advantages of Type Erasure
Type erasure is necessary in Java's generics to ensure compatibility with existing non-generic code and libraries while minimizing the runtime overhead introduced by introducing generics.

Here are the key reasons why type erasure is necessary:

1. **Backward Compatibility:** Type erasure allows generic code to work seamlessly with pre-existing non-generic code and libraries. This is crucial for maintaining compatibility with Java's extensive ecosystem of libraries and applications that were developed before generics were introduced.

2. **Minimized Runtime Overhead:** Type erasure helps avoid the creation of specialized versions of classes for each type parameter. This minimizes the amount of bytecode generated and reduces the runtime memory overhead, making the introduction of generics less resource-intensive.

3. **Code Optimization:** By performing type erasure, the compiler can optimize code more effectively. The elimination of generic type information at runtime simplifies the execution of instructions, making the code more efficient.

4. **Type Safety at Compile Time:** Despite type erasure, generics provide type safety at compile time by enforcing type checking and constraints. This ensures that incompatible types are caught during compilation, reducing the likelihood of runtime errors.

5. **Simplicity:** Type erasure simplifies the overall language design and implementation. It allows developers to work with generics without having to manage complex interactions between specialized versions of classes.

While type erasure has some trade-offs, such as the loss of specific type information at runtime, it strikes a balance between backward compatibility, runtime efficiency, and type safety. It allows Java to provide the benefits of generics while preserving compatibility with existing codebases and optimizing runtime performance.