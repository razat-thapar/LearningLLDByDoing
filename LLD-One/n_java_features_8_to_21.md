# Java LTS Features Cheat Sheet

## Java 8 (LTS) - March 2014

### Lambda Expressions
```java
// Before
list.forEach(new Consumer<String>() {
    public void accept(String s) {
        System.out.println(s);
    }
});

// After
list.forEach(s -> System.out.println(s));
```

### Stream API
```java
List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");

// Filter, map, collect
List<String> result = names.stream()
    .filter(name -> name.startsWith("J"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

### Optional
```java
// Avoid null checks
Optional<String> name = Optional.ofNullable(getName());
String result = name.orElse("Default Name");

// Or throw exception
String result = name.orElseThrow(() -> new Exception("Name not found"));
```

### Default Methods in Interfaces
```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle starting...");
    }
}
```

### Date/Time API
```java
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 15);
Period age = Period.between(birthday, today);

LocalDateTime meeting = LocalDateTime.of(2024, 1, 20, 14, 30);
```

---

## Java 11 (LTS) - September 2018

### Local Variable Type Inference (var) - from Java 10
```java
// Compiler infers the type
var list = new ArrayList<String>();
var map = new HashMap<String, Integer>();
var message = "Hello World";
```

### New String Methods
```java
String text = "  Hello World  ";
text.isBlank();              // false
text.strip();                // "Hello World"
text.repeat(3);              // "  Hello World    Hello World    Hello World  "

String multiline = "Line1\nLine2\nLine3";
multiline.lines().forEach(System.out::println);  // Stream of lines
```

### New File Methods
```java
// Read file as String
String content = Files.readString(Path.of("file.txt"));

// Write String to file
Files.writeString(Path.of("output.txt"), "Hello World");
```

### HTTP Client API
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .GET()
    .build();

HttpResponse<String> response = client.send(request, 
    HttpResponse.BodyHandlers.ofString());
```

### Run Java Files Directly
```bash
# No need to compile first
java HelloWorld.java
```

---

## Java 17 (LTS) - September 2021

### Records
```java
// Concise data classes
public record Person(String name, int age) {}

// Auto-generates: constructor, getters, equals, hashCode, toString
Person person = new Person("John", 30);
String name = person.name();  // getter
int age = person.age();       // getter
```

### Sealed Classes
```java
// Control which classes can extend
public sealed class Shape 
    permits Circle, Rectangle, Square {}

public final class Circle extends Shape {}
public final class Rectangle extends Shape {}
public non-sealed class Square extends Shape {}  // can be extended further
```

### Pattern Matching for instanceof
```java
// Before
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.length());
}

// After
if (obj instanceof String s) {
    System.out.println(s.length());  // s is auto-cast
}
```

### Text Blocks (from Java 15)
```java
// Multi-line strings
String json = """
    {
        "name": "John",
        "age": 30,
        "city": "New York"
    }
    """;

String sql = """
    SELECT id, name, email
    FROM users
    WHERE age > 18
    ORDER BY name
    """;
```

---

## Java 21 (LTS) - September 2023

### Virtual Threads

**What are Virtual Threads?**
- Lightweight threads managed by the JVM, not the OS
- Part of Project Loom
- Enable massive scalability for concurrent applications

**Platform Threads vs Virtual Threads:**

| Platform Threads (OS Threads) | Virtual Threads |
|-------------------------------|-----------------|
| Heavy (~2MB stack per thread) | Lightweight (~few KB) |
| Limited by OS (few thousands) | Millions possible |
| 1:1 mapping with OS threads   | Many-to-few mapping (JVM manages) |
| Expensive to create/destroy   | Cheap to create/destroy |
| Blocking wastes OS resources  | Blocking doesn't waste carrier thread |

**Problem They Solve:**

Traditional approach had two bad choices:
1. **Thread-per-request model**: Simple but doesn't scale (limited threads)
2. **Async/reactive model**: Scales but complex code (callbacks, CompletableFuture chains)

Virtual threads give you **both**: simple synchronous code that scales to millions of requests.

**Examples:**

```java
// Creating virtual threads
Thread vThread = Thread.ofVirtual().start(() -> {
    System.out.println("Running in virtual thread");
});

// Virtual thread with name
Thread.ofVirtual()
    .name("my-virtual-thread")
    .start(() -> System.out.println("Hello"));

// Using ExecutorService (recommended)
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 1_000_000; i++) {
        executor.submit(() -> {
            Thread.sleep(Duration.ofSeconds(1));  // Doesn't block carrier thread
            return "Result";
        });
    }
}  // Automatically waits for all tasks

// Real-world example: HTTP server handling requests
void handleRequest(Request request) {
    Thread.ofVirtual().start(() -> {
        // Each request gets its own virtual thread
        String data = fetchFromDatabase();  // blocking call - no problem!
        String result = callExternalAPI();  // blocking call - no problem!
        sendResponse(result);
    });
}
```

**Key Benefits:**
- Write simple blocking code (no callbacks, no reactive complexity)
- Scale to millions of concurrent tasks
- Better resource utilization (blocking doesn't waste threads)
- Perfect for I/O-bound tasks (network, database calls)

**When to Use:**
- High-throughput servers (web servers, microservices)
- Applications with many concurrent I/O operations
- Tasks that spend time waiting (network, database)

**When NOT to Use:**
- CPU-intensive tasks (use platform threads or parallel streams)
- Tasks that need precise thread control

### Pattern Matching for switch
```java
// Pattern matching with switch
Object obj = getObject();

String result = switch (obj) {
    case String s -> "String of length " + s.length();
    case Integer i -> "Integer: " + i;
    case null -> "It's null";
    default -> "Something else";
};

// With Record Patterns
record Point(int x, int y) {}

String location = switch (point) {
    case Point(0, 0) -> "Origin";
    case Point(int x, 0) -> "On X-axis at " + x;
    case Point(0, int y) -> "On Y-axis at " + y;
    case Point(int x, int y) -> "Point at " + x + ", " + y;
};
```

### Sequenced Collections
```java
List<String> list = new ArrayList<>(List.of("A", "B", "C"));

// New methods
String first = list.getFirst();     // "A"
String last = list.getLast();       // "C"
list.addFirst("Z");                 // [Z, A, B, C]
list.addLast("D");                  // [Z, A, B, C, D]

List<String> reversed = list.reversed();  // [D, C, B, A, Z]
```

### Record Patterns (Standardized)
```java
record Point(int x, int y) {}
record Circle(Point center, int radius) {}

// Nested pattern matching
Object shape = new Circle(new Point(0, 0), 10);

if (shape instanceof Circle(Point(int x, int y), int r)) {
    System.out.println("Circle at (" + x + "," + y + ") with radius " + r);
}
```

---

## Quick Reference

**Java 8:** Lambdas, Streams, Optional, Date/Time API  
**Java 11:** var, String methods, HTTP Client, Files.readString/writeString  
**Java 17:** Records, Sealed Classes, Pattern Matching instanceof, Text Blocks  
**Java 21:** Virtual Threads, Pattern Matching switch, Sequenced Collections