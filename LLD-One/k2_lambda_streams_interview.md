# Lambdas and Streams - Interview Guide

## Lambda Expressions

### What is a Lambda Expression?

**Simple Definition:** A lambda is an anonymous function (a function without a name) that you can pass around like a variable.

**Syntax:**
```
(parameters) -> expression
or
(parameters) -> { statements; }
```

**Example:**
```java
// Traditional way
Comparator<String> comp = new Comparator<String>() {
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
};

// Lambda way
Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
```

### Why Was Lambda Added to Java?

#### 1. **Support for Functional Programming**

**a) Pass functions as arguments**
```java
// Before Java 8: Had to create entire class
list.sort(new Comparator<String>() {
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
});

// With Lambda: Pass behavior directly
list.sort((s1, s2) -> s1.compareTo(s2));
```

**b) Assign functions to variables**
```java
// Store behavior in a variable
Function<Integer, Integer> square = x -> x * x;
int result = square.apply(5); // result = 25
```

**c) Return functions from methods**
```java
public Function<Integer, Integer> createMultiplier(int factor) {
    return x -> x * factor;
}

Function<Integer, Integer> triple = createMultiplier(3);
int result = triple.apply(4); // result = 12
```

#### 2. **Reduce Boilerplate Code**

**Problem:** Too much code for simple operations
```java
// 7 lines just to start a thread!
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Running");
    }
});
thread.start();
```

**Solution:** Lambda reduces it to 1 line
```java
Thread thread = new Thread(() -> System.out.println("Running"));
thread.start();
```

#### 3. **Enable Stream API**

Lambdas make the Stream API possible and practical:
```java
// Without lambda - verbose and unclear
List<String> result = new ArrayList<>();
for (String name : names) {
    if (name.startsWith("A")) {
        result.add(name.toUpperCase());
    }
}

// With lambda - clear and concise
List<String> result = names.stream()
    .filter(name -> name.startsWith("A"))
    .map(String::toUpperCase)
    .toList();
```

#### 4. **Better Parallelism Support**

Lambdas enable easy parallel processing:
```java
// Sequential processing
list.stream().forEach(item -> process(item));

// Parallel processing - just add parallel()
list.parallelStream().forEach(item -> process(item));
```

### How Do Lambdas Work?

#### 1. **Requirements: Functional Interface**

A lambda can only be used with a **Functional Interface** (an interface with exactly ONE abstract method).

**Examples of Functional Interfaces:**
```java
@FunctionalInterface
interface Printable {
    void print(String message);
}

// Use it with lambda
Printable printer = msg -> System.out.println(msg);
printer.print("Hello"); // Output: Hello
```

#### 2. **Lambda Syntax Variations**

**No parameters:**
```java
() -> System.out.println("Hello")
```

**One parameter (parentheses optional):**
```java
x -> x * x
// or
(x) -> x * x
```

**Multiple parameters:**
```java
(x, y) -> x + y
```

**Multiple statements (need curly braces and return keyword):**
```java
(x, y) -> {
    int sum = x + y;
    return sum * 2;
}
```

**With type declarations:**
```java
(Integer x, Integer y) -> x + y
```

#### 3. **Common Functional Interfaces (Built-in)**

**Predicate<T>** - Takes one argument, returns boolean
```java
Predicate<Integer> isEven = num -> num % 2 == 0;
System.out.println(isEven.test(4)); // true
```

**Function<T, R>** - Takes one argument of type T, returns type R
```java
Function<String, Integer> length = str -> str.length();
System.out.println(length.apply("Hello")); // 5
```

**Consumer<T>** - Takes one argument, returns nothing
```java
Consumer<String> print = str -> System.out.println(str);
print.accept("Hello"); // Output: Hello
```

**Supplier<T>** - Takes no argument, returns type T
```java
Supplier<Double> random = () -> Math.random();
System.out.println(random.get()); // random number
```

**BiFunction<T, U, R>** - Takes two arguments (T, U), returns R
```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
System.out.println(add.apply(5, 3)); // 8
```

#### 4. **Variable Capture (Effectively Final)**

Lambdas can use variables from outer scope, but they must be **effectively final** (not modified after initialization).

```java
int factor = 2;
Function<Integer, Integer> multiplier = num -> num * factor; // OK

factor = 3; // ERROR! Cannot modify variable used in lambda
```

### Method References (Shorthand for Lambdas)

#### What is a Method Reference?

**Simple Definition:** Method reference is a shorthand notation for a lambda expression that only calls an existing method. It uses the `::` operator.

#### Why Use Method References?

1. **More Readable:** `String::toUpperCase` is clearer than `s -> s.toUpperCase()`
2. **Less Code:** Reduces boilerplate when lambda just calls one method
3. **Cleaner:** Makes intent obvious at a glance

**When to use:**
- Lambda only calls an existing method
- Lambda doesn't add any additional logic

```java
// Lambda - verbose
list.forEach(item -> System.out.println(item));

// Method reference - concise
list.forEach(System.out::println);
```

**Types of Method References:**

1. **Static method:** `ClassName::methodName`
```java
Function<String, Integer> parser = Integer::parseInt;
```

2. **Instance method of particular object:** `object::methodName`
```java
String prefix = "Hello ";
Function<String, String> greeter = prefix::concat;
```

3. **Instance method of arbitrary object:** `ClassName::methodName`
```java
Function<String, Integer> length = String::length;
```

4. **Constructor:** `ClassName::new`
```java
Supplier<ArrayList> listSupplier = ArrayList::new;
```
---

#### Quick Comparison Table

| Type | Lambda | Method Reference |
|------|--------|------------------|
| Static Method | `str -> Integer.parseInt(str)` | `Integer::parseInt` |
| Instance (Specific) | `() -> obj.method()` | `obj::method` |
| Instance (Arbitrary) | `str -> str.length()` | `String::length` |
| Constructor | `() -> new ArrayList()` | `ArrayList::new` |

---

#### Important Notes for Interviews

**1. Method reference must match functional interface signature:**
```java
// This works - both take String and return int
Function<String, Integer> f = Integer::parseInt;

// This won't work - signatures don't match
Consumer<String> c = Integer::parseInt;  // ERROR! parseInt returns int
```

**2. Method reference works only with functional interfaces:**
```java
@FunctionalInterface
interface I {
    void greet(String name);
}

class B {
    public static void welcome(String user) {
        System.out.println("WELCOME! " + user);
    }
}

// Works because I is functional interface
I i1 = B::welcome;
i1.greet("Suraj");  // Output: WELCOME! Suraj
```

**3. Method reference requirements:**
- Must work **only based on count of arguments** (parameter matching)
- Must work **only with functional interfaces** (single abstract method)
- Works **with constructors as well**

**4. When NOT to use method references:**
```java
// Can't use method reference - lambda has additional logic
list.stream().map(s -> s.toUpperCase() + "!");  // Keep as lambda

// Can't use method reference - lambda transforms the call
list.stream().map(s -> Integer.parseInt(s) * 2);  // Keep as lambda
```

---

#### Common Interview Examples

**Example 1: Filtering null values**
```java
// Lambda
list.stream().filter(item -> item != null)

// Method reference
list.stream().filter(Objects::nonNull)
```

**Example 2: Sorting by name**
```java
// Lambda
people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()))

// Method reference (with Comparator.comparing)
people.sort(Comparator.comparing(Person::getName))
```

**Example 3: Collecting to list**
```java
// Lambda
list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList())

// Method reference
list.stream().map(String::toUpperCase).toList()
```

**Example 4: Creating objects**
```java
// Lambda
list.stream().map(name -> new Person(name))

// Method reference
list.stream().map(Person::new)
```

---

## Streams

### What is a Stream?

**Simple Definition:** A Stream is a sequence of elements that supports sequential and parallel operations to process data in a declarative way.

**Key Point:** Streams don't store data - they process data from a source (collection, array, etc.)

### Why Use Streams?

#### 1. **More Readable Code**

**Imperative (traditional) way:**
```java
List<String> result = new ArrayList<>();
for (String name : names) {
    if (name.length() > 3) {
        String upper = name.toUpperCase();
        result.add(upper);
    }
}
```

**Declarative (Stream) way:**
```java
List<String> result = names.stream()
    .filter(name -> name.length() > 3)
    .map(String::toUpperCase)
    .toList();
```

#### 2. **Easy Parallelization**

```java
// Change .stream() to .parallelStream() for parallel processing
long count = names.parallelStream()
    .filter(name -> name.startsWith("A"))
    .count();
```

#### 3. **Lazy Evaluation**

Operations are only executed when needed (when terminal operation is called):
```java
// Nothing happens yet!
Stream<String> filtered = names.stream()
    .filter(name -> name.startsWith("A"));

// Now it executes
List<String> result = filtered.toList();
```

#### 4. **Built-in Operations**

Streams provide many useful operations out of the box (filter, map, reduce, etc.)

### How to Create Streams?

**From Collection:**
```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
```

**From Array:**
```java
String[] array = {"a", "b", "c"};
Stream<String> stream = Arrays.stream(array);
```

**Using Stream.of():**
```java
Stream<String> stream = Stream.of("a", "b", "c");
```

**Generate infinite streams:**
```java
// Infinite stream of random numbers
Stream<Double> randoms = Stream.generate(Math::random);

// Infinite stream: 0, 1, 2, 3...
Stream<Integer> numbers = Stream.iterate(0, n -> n + 1);
```

**From range (for numbers):**
```java
IntStream numbers = IntStream.range(1, 10); // 1 to 9
IntStream numbers = IntStream.rangeClosed(1, 10); // 1 to 10
```

### Stream Operations

There are **two types** of operations:

1. **Intermediate Operations** - Return a new stream (lazy)
2. **Terminal Operations** - Produce a result (trigger execution)

#### Intermediate Operations

**filter()** - Keep elements matching condition
```java
List<Integer> evens = numbers.stream()
    .filter(n -> n % 2 == 0)
    .toList();
```

**map()** - Transform each element
```java
List<Integer> squares = numbers.stream()
    .map(n -> n * n)
    .toList();
```

**flatMap()** - Flatten nested structures
```java
List<List<String>> nested = Arrays.asList(
    Arrays.asList("a", "b"),
    Arrays.asList("c", "d")
);

List<String> flat = nested.stream()
    .flatMap(list -> list.stream())
    .toList(); // ["a", "b", "c", "d"]
```

**distinct()** - Remove duplicates
```java
List<Integer> unique = numbers.stream()
    .distinct()
    .toList();
```

**sorted()** - Sort elements
```java
List<String> sorted = names.stream()
    .sorted()
    .toList();

// Custom sorting
List<String> sorted = names.stream()
    .sorted((a, b) -> a.length() - b.length())
    .toList();
```

**limit()** - Take first n elements
```java
List<Integer> first5 = numbers.stream()
    .limit(5)
    .toList();
```

**skip()** - Skip first n elements
```java
List<Integer> afterFirst5 = numbers.stream()
    .skip(5)
    .toList();
```

**peek()** - Perform action on each element (for debugging)
```java
List<Integer> result = numbers.stream()
    .peek(n -> System.out.println("Before: " + n))
    .map(n -> n * 2)
    .peek(n -> System.out.println("After: " + n))
    .toList();
```

#### Terminal Operations

**forEach()** - Perform action on each element
```java
names.stream()
    .forEach(name -> System.out.println(name));
```

**collect()** - Collect elements into a collection
```java
// To List
List<String> list = stream.collect(Collectors.toList());
// Or simpler:
List<String> list = stream.toList();

// To Set
Set<String> set = stream.collect(Collectors.toSet());

// To Map
Map<String, Integer> map = names.stream()
    .collect(Collectors.toMap(
        name -> name,           // key
        name -> name.length()   // value
    ));

// Joining strings
String result = names.stream()
    .collect(Collectors.joining(", ")); // "A, B, C"
```

**reduce()** - Combine elements into single result
```java
// Sum of numbers
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);

// Product of numbers
int product = numbers.stream()
    .reduce(1, (a, b) -> a * b);

// Find longest string
Optional<String> longest = names.stream()
    .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
```

**count()** - Count elements
```java
long count = names.stream()
    .filter(name -> name.startsWith("A"))
    .count();
```

**anyMatch()** - Check if any element matches
```java
boolean hasEven = numbers.stream()
    .anyMatch(n -> n % 2 == 0);
```

**allMatch()** - Check if all elements match
```java
boolean allPositive = numbers.stream()
    .allMatch(n -> n > 0);
```

**noneMatch()** - Check if no elements match
```java
boolean noNegative = numbers.stream()
    .noneMatch(n -> n < 0);
```

**findFirst()** - Get first element
```java
Optional<String> first = names.stream()
    .filter(name -> name.startsWith("A"))
    .findFirst();

// Use the result
first.ifPresent(name -> System.out.println(name));
```

**findAny()** - Get any element (useful for parallel streams)
```java
Optional<String> any = names.parallelStream()
    .filter(name -> name.startsWith("A"))
    .findAny();
```

**min() / max()** - Find minimum/maximum
```java
Optional<Integer> min = numbers.stream()
    .min(Integer::compareTo);

Optional<Integer> max = numbers.stream()
    .max(Integer::compareTo);
```

### Important Stream Characteristics

#### 1. **Streams are One-Time Use**
```java
Stream<String> stream = names.stream();
stream.forEach(System.out::println); // OK

stream.forEach(System.out::println); // ERROR! Stream already used
```

#### 2. **Streams Don't Modify Source**
```java
List<String> names = Arrays.asList("Alice", "Bob");
names.stream()
    .map(String::toUpperCase)
    .forEach(System.out::println); // ALICE, BOB

System.out.println(names); // [Alice, Bob] - unchanged!
```

#### 3. **Order of Operations Matters**
```java
// Less efficient - filters all, then limits
stream.filter(expensive).limit(5);

// More efficient - limits first, then filters less items
stream.limit(10).filter(expensive);
```

### Common Interview Examples

#### Example 1: Find sum of squares of even numbers
```java
int sum = numbers.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .reduce(0, Integer::sum);
```

#### Example 2: Group employees by department
```java
Map<String, List<Employee>> byDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment));
```

#### Example 3: Find average salary by department
```java
Map<String, Double> avgSalary = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.averagingDouble(Employee::getSalary)
    ));
```

#### Example 4: Get top 3 highest salaries
```java
List<Double> top3 = employees.stream()
    .map(Employee::getSalary)
    .sorted(Comparator.reverseOrder())
    .limit(3)
    .toList();
```

#### Example 5: Remove duplicates and sort
```java
List<String> result = names.stream()
    .distinct()
    .sorted()
    .toList();
```

---

## Quick Reference Cheat Sheet

### Lambda Syntax
```java
// No params:        () -> expression
// One param:        x -> expression
// Multiple params:  (x, y) -> expression
// Multiple lines:   (x, y) -> { statements; return result; }
```

### Common Functional Interfaces
- **Predicate<T>**: `T -> boolean` (test)
- **Function<T,R>**: `T -> R` (apply)
- **Consumer<T>**: `T -> void` (accept)
- **Supplier<T>**: `() -> T` (get)
- **BiFunction<T,U,R>**: `(T,U) -> R` (apply)

### Stream Pipeline Pattern
```java
source.stream()                    // Create stream
    .intermediateOp1()             // Transform
    .intermediateOp2()             // Transform
    .terminalOp();                 // Produce result
```

### Key Interview Points

**Lambdas:**
- Requires functional interface (one abstract method)
- Variables must be effectively final
- Makes code more concise and readable
- Enables functional programming in Java

**Streams:**
- Don't modify the source
- Can only be used once
- Lazy evaluation (until terminal operation)
- Easy to parallelize with `.parallelStream()`
- Two types: intermediate (return stream) and terminal (return result)

---

## Common Interview Questions

**Q: What's the difference between map() and flatMap()?**
- `map()`: Transforms each element (one-to-one)
- `flatMap()`: Transforms and flattens (one-to-many)

**Q: Why can't lambdas modify local variables?**
- Variables must be effectively final to ensure thread safety and avoid confusion

**Q: What's the difference between Stream and Collection?**
- Collection stores data, Stream processes data
- Collection can be traversed multiple times, Stream only once
- Streams support lazy evaluation and parallel processing

**Q: When to use parallel streams?**
- Use for CPU-intensive operations on large datasets
- Avoid for small datasets (overhead > benefit)
- Avoid when operations have side effects or depend on order

## Advanced 
### Collectors.groupingBy()
Absolutely 😄
`Collectors.groupingBy` is one of those APIs that feels *mystical* until it clicks—then it becomes your **go-to interview weapon**.

I’ll teach it in a **progressive, mental-model way**, not by dumping signatures.

---

#### 🧠 First: What `groupingBy` REALLY does

Think of `groupingBy` as:

> **“Split elements into buckets based on a key.”**

In plain English:

```text
Take a stream
→ decide a key for each element
→ put elements with the same key together
```

---

#### 1️⃣ Simplest form (1-argument)

```java
Collectors.groupingBy(classifier)
```

#### Example

```java
List<String> names = List.of("apple", "ant", "ball", "bat");

Map<Character, List<String>> map =
    names.stream()
         .collect(Collectors.groupingBy(s -> s.charAt(0)));
```

#### Result

```text
a → [apple, ant]
b → [ball, bat]
```

📌 **Default behavior**

* Map type: `HashMap`
* Value type: `List<T>`

---

#### 2️⃣ Adding a downstream collector (MOST IMPORTANT)

```java
Collectors.groupingBy(classifier, downstream)
```

#### Example: frequency count

```java
String str = "banana";

Map<Character, Long> freq =
    str.chars()
       .mapToObj(c -> (char) c)
       .collect(Collectors.groupingBy(
           c -> c,
           Collectors.counting()
       ));
```

#### Result

```text
b → 1
a → 3
n → 2
```

📌 Mental model:

> “Group first, then apply something to each group.”

---

#### 3️⃣ Full power form (3-argument) 💥

```java
Collectors.groupingBy(classifier, mapFactory, downstream)
```

#### Example: preserve order (interview favorite)

```java
Map<Character, Long> freq =
    str.chars()
       .mapToObj(c -> (char) c)
       .collect(Collectors.groupingBy(
           c -> c,
           LinkedHashMap::new,
           Collectors.counting()
       ));
```

📌 Why?

* `HashMap` ❌ loses order
* `LinkedHashMap` ✅ preserves insertion order

---

#### 🧩 Common downstream collectors (memorize this)

| Downstream                  | Meaning                |
| --------------------------- | ---------------------- |
| `Collectors.counting()`     | count elements         |
| `Collectors.toList()`       | collect values         |
| `Collectors.toSet()`        | unique values          |
| `Collectors.summingInt()`   | sum                    |
| `Collectors.averagingInt()` | average                |
| `Collectors.mapping()`      | transform then collect |
| `Collectors.maxBy()`        | max per group          |
| `Collectors.minBy()`        | min per group          |

---

#### 4️⃣ Real interview examples

---

#### 🔹 Frequency Map (classic)

```java
Map<Character, Long> freq =
    str.chars()
       .mapToObj(c -> (char) c)
       .collect(Collectors.groupingBy(
           c -> c,
           Collectors.counting()
       ));
```

---

#### 🔹 Group by length

```java
Map<Integer, List<String>> byLength =
    names.stream()
         .collect(Collectors.groupingBy(String::length));
```

---

#### 🔹 Group + transform (mapping)

```java
Map<Character, List<Integer>> map =
    names.stream()
         .collect(Collectors.groupingBy(
             s -> s.charAt(0),
             Collectors.mapping(String::length, Collectors.toList())
         ));
```

---

#### 🔹 Group + max value

```java
Map<Character, Optional<String>> longest =
    names.stream()
         .collect(Collectors.groupingBy(
             s -> s.charAt(0),
             Collectors.maxBy(Comparator.comparingInt(String::length))
         ));
```

---

#### 5️⃣ groupingBy vs toMap (VERY common question)

#### `toMap`

```java
Collectors.toMap(k, v, mergeFn)
```

* You handle collisions manually
* Better for **simple maps**

#### `groupingBy`

```java
Collectors.groupingBy(k, downstream)
```

* Automatically handles duplicates
* Better for **aggregation**

📌 Interview line:

> “If duplicates are expected, `groupingBy` is safer than `toMap`.”

---

#### 6️⃣ Why `groupingBy` is powerful

Because it:

* replaces nested loops
* removes mutable maps
* expresses intent clearly
* composes cleanly

---

#### 7️⃣ One mental cheat-sheet 🧠

```text
groupingBy(
    how_to_group,
    what_map_to_use,
    what_to_do_with_each_group
)
```

---

#### 🎯 Interview-ready explanation (30 seconds)

> “`Collectors.groupingBy` groups stream elements based on a classifier function and optionally applies a downstream collector to each group. It’s commonly used for frequency maps, aggregations, and hierarchical grouping.”

---
