# Exception Handling - Interview Guide

## Table of Contents
- [What is an Exception?](#what-is-an-exception)
- [Why Exception Handling?](#why-exception-handling)
- [Types of Exceptions](#types-of-exceptions)
  - [Checked Exceptions](#checked-exceptions)
  - [Unchecked Exceptions](#unchecked-exceptions)
  - [Why Two Types?](#why-two-types-of-exceptions)
- [Handling Exceptions](#handling-exceptions)
  - [try-catch Block](#the-try-catch-block)
  - [Multiple catch Blocks](#multiple-catch-blocks)
  - [finally Block](#the-finally-block)
- [Throwing Exceptions](#throwing-exceptions)
- [Custom Exceptions](#custom-exceptions)
- [Exception Handling in Spring](#exception-handling-in-spring)
- [Best Practices](#best-practices)
- [Interview Questions](#common-interview-questions)

---

## What is an Exception?

**Simple Definition:** An exception is an unexpected event that disrupts the normal flow of program execution.

**Example:**
```java
int result = 10 / 0; // ArithmeticException - can't divide by zero!
```

When this happens:
1. An exception object is created
2. Normal program flow stops
3. JVM looks for exception handler
4. If no handler found → program crashes

**Think of it as:** An alarm going off when something goes wrong.

---

## Why Exception Handling?

### Without Exception Handling
```java
public class NoExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println("Before exception");
        System.out.println(numbers[10]); // Crash here!
        System.out.println("After exception"); // Never executes
    }
}
```
**Output:**
```
Before exception
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
```
Program crashes, "After exception" never prints.

### With Exception Handling
```java
public class WithExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println("Before exception");
            System.out.println(numbers[10]);
            System.out.println("After exception"); // Skipped
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index");
        }
        System.out.println("Program continues"); // This executes!
    }
}
```
**Output:**
```
Before exception
Error: Invalid index
Program continues
```
Program handles error gracefully and continues.

### Benefits of Exception Handling

1. **Prevents crashes** - Program doesn't terminate abruptly
2. **Separates error handling** - Clean code structure
3. **Meaningful error messages** - Better user experience
4. **Resource cleanup** - Close files, connections properly
5. **Debugging information** - Stack traces help find issues

---

## Types of Exceptions

### Exception Hierarchy

```
Throwable
├── Error (System errors - don't catch these)
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
└── Exception
    ├── RuntimeException (Unchecked)
    │   ├── NullPointerException
    │   ├── ArithmeticException
    │   ├── ArrayIndexOutOfBoundsException
    │   └── IllegalArgumentException
    │
    └── Other Exceptions (Checked)
        ├── IOException
        ├── SQLException
        ├── ClassNotFoundException
        └── FileNotFoundException
```

---

## Checked Exceptions

### What are Checked Exceptions?

**Simple Definition:** Exceptions that the compiler forces you to handle at compile-time.

**Key Characteristics:**
- Checked at **compile-time**
- Must be handled using `try-catch` OR declared with `throws`
- Extend `Exception` class (but NOT `RuntimeException`)
- Represent **recoverable** conditions

### Common Checked Exceptions

| Exception | When it occurs |
|-----------|----------------|
| `IOException` | File/network operations fail |
| `FileNotFoundException` | File doesn't exist |
| `SQLException` | Database operation fails |
| `ClassNotFoundException` | Class not found at runtime |
| `InterruptedException` | Thread is interrupted |

### Example: FileNotFoundException

```java
import java.io.FileReader;
import java.io.FileNotFoundException;

public class CheckedExceptionExample {
    // Option 1: Handle with try-catch
    public void readFileWithTryCatch() {
        try {
            FileReader reader = new FileReader("data.txt");
            System.out.println("File found!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }
    
    // Option 2: Declare with throws
    public void readFileWithThrows() throws FileNotFoundException {
        FileReader reader = new FileReader("data.txt");
        // Caller must handle this exception
    }
    
    // Won't compile - must handle or declare!
    public void readFileNoHandling() {
        FileReader reader = new FileReader("data.txt"); // COMPILE ERROR!
    }
}
```

### Why Checked Exceptions Exist

**Reason:** For problems the caller **can reasonably recover from**

```java
public void uploadFile(String path) throws FileNotFoundException {
    FileReader reader = new FileReader(path);
    // Process file
}

// Caller can recover by:
public void handleUpload() {
    try {
        uploadFile("report.pdf");
    } catch (FileNotFoundException e) {
        // Recovery options:
        System.out.println("File not found. Please select another file.");
        // Show file picker dialog
        // Use default file
        // Retry with different path
    }
}
```

---

## Unchecked Exceptions

### What are Unchecked Exceptions?

**Simple Definition:** Exceptions that the compiler does NOT force you to handle (runtime exceptions).

**Key Characteristics:**
- NOT checked at compile-time
- Extend `RuntimeException` class
- Represent **programming errors**
- Optional to handle

### Common Unchecked Exceptions

| Exception | When it occurs | How to prevent |
|-----------|----------------|----------------|
| `NullPointerException` | Accessing null object | Check for null before use |
| `ArithmeticException` | Math error (e.g., divide by 0) | Validate divisor |
| `ArrayIndexOutOfBoundsException` | Invalid array index | Check array bounds |
| `IllegalArgumentException` | Invalid method argument | Validate input |
| `ClassCastException` | Invalid type casting | Use instanceof check |
| `NumberFormatException` | Invalid string to number conversion | Validate string format |

### Example: Unchecked Exceptions

```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        // NullPointerException
        String name = null;
        System.out.println(name.length()); // Crash!
        
        // ArithmeticException
        int result = 10 / 0; // Crash!
        
        // ArrayIndexOutOfBoundsException
        int[] arr = {1, 2, 3};
        System.out.println(arr[10]); // Crash!
        
        // NumberFormatException
        int num = Integer.parseInt("abc"); // Crash!
    }
}
```

### Handling Unchecked Exceptions (Optional)

```java
public class HandleUnchecked {
    public static void main(String[] args) {
        // You CAN handle them if you want
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        }
    }
    
    static int divide(int a, int b) {
        // No need to declare throws for unchecked exceptions
        return a / b;
    }
}
```

### Prevention is Better than Handling

```java
public class PreventUnchecked {
    // Bad - relies on exception handling
    public String getNameBad(User user) {
        try {
            return user.getName().toUpperCase();
        } catch (NullPointerException e) {
            return "Unknown";
        }
    }
    
    // Good - prevents exception
    public String getNameGood(User user) {
        if (user == null || user.getName() == null) {
            return "Unknown";
        }
        return user.getName().toUpperCase();
    }
}
```

---

## Why Two Types of Exceptions?

### The Core Philosophy

**Checked Exceptions** - External problems you **MUST** plan for ( Caller can fix them but dev need to explicitly show meaningful messages or let caller handle them!)

**Unchecked Exceptions** - Programming bugs you **SHOULD** fix

### Real-World Analogy

Think of driving a car:

**Checked Exceptions** = Traffic conditions
- You KNOW traffic might be heavy
- You MUST plan for it (leave early, check GPS)
- Recoverable: take alternate route

**Unchecked Exceptions** = Driving with eyes closed
- You SHOULDN'T drive with eyes closed (programming error)
- Don't need to "plan" for it - just don't do it!
- Not recoverable: open your eyes and drive properly

### Reason 1: Compiler Enforcement vs Developer Choice

**Checked exceptions force you to think:**
```java
// Compiler won't let you ignore this
public void saveToFile() {
    FileWriter writer = new FileWriter("data.txt"); // COMPILE ERROR!
    // Must add: try-catch OR throws FileNotFoundException
}
```

**Unchecked exceptions give you freedom:**
```java
// Compiler allows this
public int divide(int a, int b) {
    return a / b; // Might throw ArithmeticException - no compile error
}
```

**Why this matters:**
- File operations CAN fail (disk full, no permission) → MUST handle
- Division by zero SHOULDN'T happen (validate input) → Fix the code

### Reason 2: Recoverability

**Can the caller reasonably recover?**

#### Checked = YES, caller can recover
```java
public void downloadFile(String url) throws IOException {
    // Download file from internet
}

// Caller can recover:
try {
    downloadFile("http://example.com/file.pdf");
} catch (IOException e) {
    // Recovery options:
    // - Retry download
    // - Try backup URL
    // - Show error to user
    // - Use cached version
}
```

#### Unchecked = NO, it's a bug in code
```java
public void processUser(User user) {
    String name = user.getName(); // NullPointerException if user is null
    // If this throws NPE, caller can't "recover"
    // Caller needs to FIX their code to not pass null
}

// This is a BUG, not a scenario to handle:
User user = null;
processUser(user); // Fix: don't pass null!
```

### Reason 3: Code Pollution Problem

**If EVERYTHING was checked, code becomes messy:**

```java
// Nightmare scenario - if NullPointerException was checked:
public void processData(List<String> data) 
    throws NullPointerException {
    
    try {
        for (String item : data) { // Checked NPE
            try {
                String upper = item.toUpperCase(); // Checked NPE
                try {
                    System.out.println(upper.length()); // Checked NPE
                } catch (NullPointerException e) {
                    // Handle...
                }
            } catch (NullPointerException e) {
                // Handle...
            }
        }
    } catch (NullPointerException e) {
        // Handle...
    }
}
```

**This is ridiculous!** Unchecked exceptions prevent this noise.

### Reason 4: Design Intent

The type tells you the **nature** of the problem:

| If you see... | It means... |
|---------------|-------------|
| `throws IOException` | "This operation depends on external resources that might fail" |
| `NullPointerException` | "Bug in code - someone passed null when they shouldn't" |
| `throws SQLException` | "Database might be down - handle this scenario" |
| `IllegalArgumentException` | "Bug in code - validate your inputs!" |

---

## Handling Exceptions

### The try-catch Block

**Syntax:**
```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

**Example:**
```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            // Output: Error: / by zero
        }
    }
    
    static int divide(int a, int b) {
        return a / b;
    }
}
```

### Multiple catch Blocks

**Handle different exceptions differently:**

```java
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            String str = args[0]; // ArrayIndexOutOfBoundsException
            int num = Integer.parseInt(str); // NumberFormatException
            int result = 100 / num; // ArithmeticException
            System.out.println("Result: " + result);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: No argument provided");
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Argument must be a number");
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
            
        } catch (Exception e) {
            // Generic catch - catches anything else
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Important Rules:**
1. **Most specific first** - Catch specific exceptions before generic ones
2. **Order matters** - Parent exception catches child exceptions

```java
// Wrong - won't compile
try {
    // code
} catch (Exception e) {          // Catches everything
    // handle
} catch (IOException e) {         // ERROR: Already caught by Exception
    // never reached
}

// Correct
try {
    // code
} catch (IOException e) {         // Specific first
    // handle
} catch (Exception e) {           // Generic last
    // handle
}
```

### Multi-catch Block (Java 7+)

**Handle multiple exceptions the same way:**

```java
// Old way
try {
    // code
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}

// New way - cleaner
try {
    // code
} catch (IOException | SQLException e) {
    System.out.println("Error: " + e.getMessage());
}
```

### The finally Block

**Always executes**, whether exception occurs or not.

**Syntax:**
```java
try {
    // Code that might throw exception
} catch (ExceptionType e) {
    // Handle exception
} finally {
    // Always executes - cleanup code here
}
```

**Use cases for finally:**
- Close files
- Close database connections
- Release resources
- Cleanup operations

**Example:**
```java
import java.io.*;

public class FinallyExample {
    public void readFile() {
        FileReader reader = null;
        try {
            reader = new FileReader("data.txt");
            // Read file...
            System.out.println("Reading file");
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            
        } finally {
            // Cleanup - always runs
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("File closed");
                }
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}
```

**Finally execution order:**

```java
public class FinallyOrder {
    public static void main(String[] args) {
        System.out.println(test()); // Output: 30
    }
    
    static int test() {
        try {
            System.out.println("In try"); // 1st
            return 10;
        } catch (Exception e) {
            System.out.println("In catch"); // Skipped
            return 20;
        } finally {
            System.out.println("In finally"); // 2nd - always runs
            return 30; // This overrides return value!
        }
    }
}
```

**Output:**
```
In try
In finally
30
```

**Note:** Avoid returning from finally block - it overrides try/catch returns!

### try-with-resources (Java 7+)

**Automatic resource management** - no need for finally!

```java
// Old way - manual cleanup
public void readFileOld() {
    FileReader reader = null;
    try {
        reader = new FileReader("data.txt");
        // Use reader
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (reader != null) reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// New way - automatic cleanup
public void readFileNew() {
    try (FileReader reader = new FileReader("data.txt")) {
        // Use reader - automatically closed!
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

**Multiple resources:**
```java
try (FileReader reader = new FileReader("input.txt");
     FileWriter writer = new FileWriter("output.txt")) {
    // Use both - both automatically closed in reverse order
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## Throwing Exceptions

### Using throw keyword

**Explicitly throw an exception:**

```java
public void validateAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or above");
    }
    System.out.println("Valid age");
}
```

### Using throws keyword

**Declare that a method might throw exceptions:**

```java
public void readFile(String path) throws IOException {
    FileReader reader = new FileReader(path);
    // Caller must handle IOException
}

// Caller must handle or declare
public void processFile() {
    try {
        readFile("data.txt");
    } catch (IOException e) {
        System.out.println("Error reading file");
    }
}
```

### throw vs throws

| `throw` | `throws` |
|---------|----------|
| Used to throw an exception | Used to declare exceptions |
| Inside method body | In method signature |
| Followed by exception object | Followed by exception class |
| `throw new Exception()` | `throws Exception` |

**Example:**
```java
public void validateInput(String input) throws InvalidInputException {
    //                                     ^^^^^^ declares exception
    if (input == null) {
        throw new InvalidInputException("Input cannot be null");
        //^^^ throws exception
    }
}
```

### Re-throwing Exceptions

**Catch, log, and re-throw:**

```java
public void processData() throws DataException {
    try {
        // Some operation
        riskyOperation();
    } catch (Exception e) {
        // Log the error
        logger.error("Error processing data", e);
        
        // Re-throw as different exception
        throw new DataException("Data processing failed", e);
    }
}
```

---

## Custom Exceptions

### Why Create Custom Exceptions?

1. **Business-specific errors** - Represent domain-specific problems
2. **Better error handling** - Different handling for different business errors
3. **Meaningful names** - `InsufficientBalanceException` vs generic `Exception`
4. **Additional context** - Add custom fields/methods

### Creating Custom Checked Exception

**Extend Exception class:**

```java
public class InsufficientBalanceException extends Exception {
    private double balance;
    private double amount;
    
    public InsufficientBalanceException(String message, double balance, double amount) {
        super(message);
        this.balance = balance;
        this.amount = amount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getShortfall() {
        return amount - balance;
    }
}
```

**Usage:**
```java
public class BankAccount {
    private double balance;
    
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance for withdrawal",
                balance,
                amount
            );
        }
        balance -= amount;
    }
}

// Using it
public class ATM {
    public void processWithdrawal(BankAccount account, double amount) {
        try {
            account.withdraw(amount);
            System.out.println("Withdrawal successful");
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Balance: $" + e.getBalance());
            System.out.println("Shortfall: $" + e.getShortfall());
        }
    }
}
```

### Creating Custom Unchecked Exception

**Extend RuntimeException class:**

```java
public class InvalidEmailException extends RuntimeException {
    private String email;
    
    public InvalidEmailException(String message, String email) {
        super(message);
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
}
```

**Usage:**
```java
public class UserService {
    public void registerUser(String email) {
        if (!isValidEmail(email)) {
            throw new InvalidEmailException("Invalid email format", email);
        }
        // Register user
    }
    
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}
```

### Checked vs Unchecked Custom Exception

```java
// Checked - for expected business scenarios
public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(String orderId) {
        super("Order not found: " + orderId);
    }
}

// Unchecked - for programming errors
public class InvalidOrderStateException extends RuntimeException {
    public InvalidOrderStateException(String message) {
        super(message);
    }
}
```

---

## Exception Handling in Spring

### Why Exception Types Matter Even with @ControllerAdvice

Great question! Even though `@ControllerAdvice` handles all exceptions centrally, the **type** still matters for:

1. **Different HTTP status codes**
2. **Different logging strategies**
3. **Transaction rollback behavior**
4. **Monitoring and alerts**

### Example: Global Exception Handler

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    // Business exceptions (Checked) → 404 Not Found
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException e) {
        logger.info("User not found: {}", e.getMessage()); // INFO level
        
        ErrorResponse error = new ErrorResponse(
            404,
            "User Not Found",
            e.getMessage(),
            LocalDateTime.now()
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    // Validation errors (Unchecked) → 400 Bad Request
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(IllegalArgumentException e) {
        logger.warn("Invalid request: {}", e.getMessage()); // WARN level
        
        ErrorResponse error = new ErrorResponse(
            400,
            "Bad Request",
            e.getMessage(),
            LocalDateTime.now()
        );
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    // Programming errors (Unchecked) → 500 Internal Server Error
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointer(NullPointerException e) {
        logger.error("CRITICAL BUG - NullPointerException:", e); // ERROR level
        alertOpsTeam(e); // Send alert to operations
        
        ErrorResponse error = new ErrorResponse(
            500,
            "Internal Server Error",
            "An unexpected error occurred",
            LocalDateTime.now()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    // Database errors (Checked) → 503 Service Unavailable
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseError(SQLException e) {
        logger.error("Database error:", e);
        alertOpsTeam(e);
        
        ErrorResponse error = new ErrorResponse(
            503,
            "Service Unavailable",
            "Database service temporarily unavailable",
            LocalDateTime.now()
        );
        
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
    }
    
    // Catch-all for unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        logger.error("Unexpected exception:", e);
        
        ErrorResponse error = new ErrorResponse(
            500,
            "Internal Server Error",
            "An unexpected error occurred",
            LocalDateTime.now()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    private void alertOpsTeam(Exception e) {
        // Send email, Slack notification, PagerDuty alert, etc.
    }
}
```

### HTTP Status Code Strategy

| Exception Type | HTTP Status | Meaning | Example |
|----------------|-------------|---------|---------|
| Resource not found | 404 | Client error - resource doesn't exist | `UserNotFoundException` |
| Invalid input | 400 | Client error - bad request | `IllegalArgumentException` |
| Authentication failed | 401 | Client error - not authenticated | `AuthenticationException` |
| Access denied | 403 | Client error - no permission | `AccessDeniedException` |
| Server bug | 500 | Server error - programming error | `NullPointerException` |
| Database down | 503 | Server error - service unavailable | `SQLException` |

### Transaction Rollback Behavior

```java
@Service
public class OrderService {
    
    @Transactional
    public void processOrder(Order order) throws OrderException {
        
        // Save order to database
        orderRepository.save(order);
        
        // Unchecked exception → AUTOMATIC ROLLBACK
        if (order.getTotal() < 0) {
            throw new IllegalStateException("Invalid order total");
            // Transaction automatically rolls back!
        }
        
        // Checked exception → NO AUTOMATIC ROLLBACK (by default)
        try {
            sendConfirmationEmail(order);
        } catch (EmailException e) {
            logger.warn("Email failed, but order is valid");
            // Transaction NOT rolled back - order still saved
            // We chose not to rollback because email failure 
            // shouldn't cancel the order
        }
    }
    
    @Transactional(rollbackFor = EmailException.class)
    public void processOrderStrictly(Order order) throws OrderException {
        orderRepository.save(order);
        sendConfirmationEmail(order); 
        // Now EmailException will also cause rollback
    }
}
```

**Default Spring Transaction Behavior:**
- **Unchecked exceptions** (RuntimeException) → Automatic rollback
- **Checked exceptions** → No automatic rollback (you decide with `rollbackFor`)

### Logging Strategy

```java
@Service
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    public User findUser(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id);
        
        if (user == null) {
            // Expected scenario - INFO level
            logger.info("User not found with id: {}", id);
            throw new UserNotFoundException("User " + id + " not found");
        }
        
        return user;
    }
    
    public void processUser(User user) {
        if (user == null) {
            // Programming error - ERROR level
            logger.error("BUG: processUser called with null user!");
            throw new IllegalArgumentException("User cannot be null");
        }
        
        // Process user
    }
}
```

### Complete Example: E-commerce Application

```java
// Custom Exceptions
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String productId) {
        super("Product not found: " + productId);
    }
}

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String productId, int available, int requested) {
        super(String.format("Insufficient stock for product %s. Available: %d, Requested: %d", 
            productId, available, requested));
    }
}

// Service Layer
@Service
public class OrderService {
    
    @Transactional
    public Order placeOrder(OrderRequest request) 
            throws ProductNotFoundException, InsufficientStockException {
        
        // Validate input - unchecked for programming errors
        if (request == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order request cannot be empty");
        }
        
        Order order = new Order();
        
        for (OrderItem item : request.getItems()) {
            // Business validation - checked exceptions
            Product product = productService.findProduct(item.getProductId());
            if (product == null) {
                throw new ProductNotFoundException(item.getProductId());
            }
            
            if (product.getStock() < item.getQuantity()) {
                throw new InsufficientStockException(
                    item.getProductId(),
                    product.getStock(),
                    item.getQuantity()
                );
            }
            
            // Update stock
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
            
            order.addItem(item);
        }
        
        return orderRepository.save(order);
    }
}

// Controller
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
        try {
            Order order = orderService.placeOrder(request);
            return ResponseEntity.ok(order);
            
        } catch (ProductNotFoundException | InsufficientStockException e) {
            // Let ControllerAdvice handle these
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

// Global Exception Handler
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException e) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse("Product not found", e.getMessage()));
    }
    
    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientStock(InsufficientStockException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponse("Insufficient stock", e.getMessage()));
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponse("Invalid request", e.getMessage()));
    }
}
```

---

## Best Practices

### General Best Practices

#### 1. Catch Specific Exceptions

```java
// Bad - too generic
try {
    // code
} catch (Exception e) {
    // What went wrong? Can't tell!
}

// Good - specific
try {
    // code
} catch (FileNotFoundException e) {
    // Handle missing file
} catch (IOException e) {
    // Handle I/O error
}
```

#### 2. Don't Swallow Exceptions

```java
// Bad - silent failure
try {
    riskyOperation();
} catch (Exception e) {
    // Empty catch - error is hidden!
}

// Good - at least log it
try {
    riskyOperation();
} catch (Exception e) {
    logger.error("Operation failed", e);
    throw e; // or handle appropriately
}
```

#### 3. Use Meaningful Error Messages

```java
// Bad - not helpful
throw new Exception("Error");

// Good - provides context
throw new IllegalArgumentException(
    "Email cannot be null or empty. Provided: " + email
);
```

#### 4. Clean Up Resources

```java
// Bad - resource leak if exception occurs
FileReader reader = new FileReader("file.txt");
// Use reader - if exception here, reader never closed!
reader.close();

// Good - always close in finally
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // Use reader
} finally {
    if (reader != null) reader.close();
}

// Best - try-with-resources
try (FileReader reader = new FileReader("file.txt")) {
    // Use reader - automatically closed
}
```

#### 5. Don't Use Exceptions for Flow Control

```java
// Bad - using exceptions for normal logic
public boolean hasNextElement(String[] array, int index) {
    try {
        String element = array[index];
        return true;
    } catch (ArrayIndexOutOfBoundsException e) {
        return false;
    }
}

// Good - use proper conditional logic
public boolean hasNextElement(String[] array, int index) {
    return index >= 0 && index < array.length;
}
```

#### 6. Provide Context When Re-throwing

```java
// Bad - loses context
try {
    processData();
} catch (IOException e) {
    throw new RuntimeException("Error"); // Original cause lost!
}

// Good - preserve cause
try {
    processData();
} catch (IOException e) {
    throw new RuntimeException("Failed to process data", e);
    //                                                   ^ cause
}
```

### Best Practices for Checked Exceptions

#### 1. Handle or Declare

Always handle checked exceptions or declare them in the method signature.

```java
// Option 1: Handle
public void readFile() {
    try {
        FileReader reader = new FileReader("data.txt");
    } catch (FileNotFoundException e) {
        // Handle the exception
    }
}

// Option 2: Declare
public void readFile() throws FileNotFoundException {
    FileReader reader = new FileReader("data.txt");
}
```

#### 2. Use for Recoverable Conditions

Only use checked exceptions for conditions the caller can reasonably recover from.

```java
// Good - caller can recover
public User findUser(Long id) throws UserNotFoundException {
    User user = repository.findById(id);
    if (user == null) {
        throw new UserNotFoundException("User " + id + " not found");
    }
    return user;
}

// Caller handles it:
try {
    User user = findUser(123L);
} catch (UserNotFoundException e) {
    // Recover: create new user, use default, show error message
}
```

#### 3. Close Resources Properly

```java
// Use try-with-resources for automatic cleanup
public void processFile(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = reader.readLine()) != null) {
            process(line);
        }
    } // Reader automatically closed
}
```

### Best Practices for Unchecked Exceptions

#### 1. Use Defensive Programming

Validate inputs to avoid unchecked exceptions.

```java
// Bad - can throw NullPointerException
public String getUpperCase(String str) {
    return str.toUpperCase();
}

// Good - validate input
public String getUpperCase(String str) {
    if (str == null) {
        throw new IllegalArgumentException("String cannot be null");
    }
    return str.toUpperCase();
}

// Even better - handle gracefully
public String getUpperCase(String str) {
    return str == null ? "" : str.toUpperCase();
}
```

#### 2. Fail Fast

Throw exceptions early when you detect invalid state.

```java
public class BankAccount {
    private double balance;
    
    // Good - fail fast
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }
}
```

#### 3. Use Appropriate Exception Types

Choose the right unchecked exception for the situation.

```java
// IllegalArgumentException - for invalid method arguments
public void setAge(int age) {
    if (age < 0 || age > 150) {
        throw new IllegalArgumentException("Age must be between 0 and 150");
    }
    this.age = age;
}

// IllegalStateException - for invalid object state
public void withdraw(double amount) {
    if (isClosed) {
        throw new IllegalStateException("Account is closed");
    }
    // Process withdrawal
}

// UnsupportedOperationException - for unsupported operations
public void add(Element e) {
    throw new UnsupportedOperationException("This list is immutable");
}

// NullPointerException - only when null is truly unexpected
public void process(Data data) {
    if (data == null) {
        throw new NullPointerException("Data cannot be null");
    }
    // Process data
}
```

#### 4. Document Unchecked Exceptions

Even though unchecked exceptions don't need to be declared, document them.

```java
/**
 * Processes user data.
 * 
 * @param user the user to process
 * @throws IllegalArgumentException if user is null
 * @throws IllegalStateException if user account is suspended
 */
public void processUser(User user) {
    if (user == null) {
        throw new IllegalArgumentException("User cannot be null");
    }
    if (user.isSuspended()) {
        throw new IllegalStateException("Cannot process suspended user");
    }
    // Process user
}
```

#### 5. Log Appropriately

```java
// Expected exceptions - INFO or WARN
try {
    processOrder(order);
} catch (IllegalArgumentException e) {
    logger.warn("Invalid order: {}", e.getMessage());
}

// Unexpected exceptions - ERROR
try {
    processOrder(order);
} catch (NullPointerException e) {
    logger.error("BUG: Unexpected null pointer", e);
}
```

---

## Common Interview Questions

### Q1: What is the difference between checked and unchecked exceptions?

**Answer:**

**Checked Exceptions:**
- Checked at compile-time
- Must be handled with try-catch or declared with throws
- Extend Exception (but not RuntimeException)
- Represent recoverable conditions (file not found, network timeout)
- Examples: IOException, SQLException

**Unchecked Exceptions:**
- Not checked at compile-time
- Extend RuntimeException
- Represent programming errors
- Optional to handle
- Examples: NullPointerException, IllegalArgumentException

**In interviews, add:**
> "Checked exceptions force the caller to handle expected scenarios like missing files, while unchecked exceptions indicate bugs that should be fixed in the code, like null pointer dereferences."

---

### Q2: What is the difference between throw and throws?

**Answer:**

| `throw` | `throws` |
|---------|----------|
| Used to actually throw an exception | Used to declare exceptions a method might throw |
| Used inside method body | Used in method signature |
| Followed by an exception **object** | Followed by exception **class name(s)** |
| Can only throw one exception at a time | Can declare multiple exceptions |
| `throw new Exception();` | `throws IOException, SQLException` |

**Example:**
```java
public void validateAge(int age) throws InvalidAgeException {
    //                            ^^^^^^ declares exception
    if (age < 18) {
        throw new InvalidAgeException("Too young");
        //^^^ throws exception object
    }
}
```

---

### Q3: Can we have multiple catch blocks? What is the order?

**Answer:**

Yes, we can have multiple catch blocks. **Order matters** - catch blocks are evaluated from top to bottom, and the first matching catch is executed.

**Rules:**
1. **Most specific exceptions first**
2. **Most generic exceptions last**
3. **Child exceptions before parent exceptions**

```java
try {
    // code
} catch (FileNotFoundException e) {     // Specific
    // handle
} catch (IOException e) {                // Parent of FileNotFoundException
    // handle
} catch (Exception e) {                  // Most generic
    // handle
}

// This won't compile - wrong order
try {
    // code
} catch (Exception e) {                  // Too generic first
    // handle
} catch (IOException e) {                // Unreachable!
    // handle
}
```

---

### Q4: What is the purpose of the finally block?

**Answer:**

The `finally` block contains code that **always executes**, regardless of whether an exception occurs or not.

**Use cases:**
- Close resources (files, database connections)
- Release locks
- Cleanup operations
- Logging

**Key points:**
- Executes even if there's a return statement in try/catch
- Executes even if exception is not caught
- Does NOT execute if JVM exits (System.exit()) or thread dies

**Example:**
```java
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    return "success";
} catch (IOException e) {
    return "error";
} finally {
    // This runs before method returns!
    if (reader != null) {
        reader.close();
    }
}
```

**Interview tip:** Mention try-with-resources as modern alternative.

---

### Q5: What is try-with-resources?

**Answer:**

Try-with-resources (Java 7+) automatically closes resources that implement `AutoCloseable`.

**Syntax:**
```java
try (ResourceType resource = new ResourceType()) {
    // Use resource
} // Resource automatically closed here
```

**Benefits:**
- No need for finally block
- Automatically closes resources
- Cleaner code
- Handles exceptions during close properly

**Example:**
```java
// Old way
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("file.txt"));
    return reader.readLine();
} finally {
    if (reader != null) {
        reader.close();
    }
}

// Try-with-resources way
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    return reader.readLine();
} // Automatically closed
```

---

### Q6: Can we have try without catch or finally?

**Answer:**

**No for try alone**, but **yes for try-with-resources:**

```java
// Won't compile - try needs catch or finally
try {
    riskyOperation();
}

// OK - try with finally
try {
    riskyOperation();
} finally {
    cleanup();
}

// OK - try with catch
try {
    riskyOperation();
} catch (Exception e) {
    handle(e);
}

// OK - try-with-resources without catch or finally
try (FileReader reader = new FileReader("file.txt")) {
    // Use reader
}
```

---

### Q7: What happens if an exception occurs in finally block?

**Answer:**

If an exception occurs in the finally block:
1. It **overrides** any exception from try/catch
2. The original exception is **lost** (unless handled properly)

```java
try {
    throw new RuntimeException("Try exception");
} finally {
    throw new RuntimeException("Finally exception");
}
// Result: "Finally exception" is thrown, "Try exception" is lost!
```

**To preserve both exceptions:**
```java
Exception original = null;
try {
    throw new RuntimeException("Try exception");
} catch (Exception e) {
    original = e;
} finally {
    try {
        // Cleanup that might throw
    } catch (Exception e) {
        if (original != null) {
            e.addSuppressed(original);
        }
        throw e;
    }
}
```

**Or use try-with-resources** - it handles this automatically!

---

### Q8: What is exception chaining?

**Answer:**

Exception chaining is wrapping one exception inside another to preserve the original cause.

**Why?**
- Transform exceptions between layers
- Preserve stack trace
- Add context while keeping root cause

```java
public void processData() throws DataException {
    try {
        database.fetchData();
    } catch (SQLException e) {
        // Chain the exception - preserve original cause
        throw new DataException("Failed to fetch data", e);
        //                                              ^ cause
    }
}

// Later, you can get the root cause:
try {
    processData();
} catch (DataException e) {
    Throwable cause = e.getCause(); // Returns SQLException
}
```

**Methods:**
- `Throwable getCause()` - Get the underlying cause
- `Throwable initCause(Throwable cause)` - Set the cause
- Constructor: `new Exception("message", cause)`

---

### Q9: What are suppressed exceptions?

**Answer:**

Suppressed exceptions occur when multiple exceptions happen in try-with-resources.

**Scenario:**
- Exception in try block
- Exception during resource close (in finally)

```java
try (Resource r = new Resource()) {
    throw new RuntimeException("Exception in try");
} // If r.close() also throws, it's suppressed

// Access suppressed exceptions:
catch (Exception e) {
    e.getMessage(); // "Exception in try"
    Throwable[] suppressed = e.getSuppressed();
    // Contains exceptions from close()
}
```

**Why it matters:**
- Try-with-resources preserves ALL exceptions
- Manual finally blocks might lose exceptions

---

### Q10: When should you create a custom exception?

**Answer:**

Create custom exceptions when:

1. **Representing business-specific errors**
```java
public class InsufficientBalanceException extends Exception {
    // Represents specific business rule violation
}
```

2. **Need to add additional context**
```java
public class OrderException extends Exception {
    private String orderId;
    private OrderStatus status;
    
    public OrderException(String msg, String orderId, OrderStatus status) {
        super(msg);
        this.orderId = orderId;
        this.status = status;
    }
    
    // Getters provide additional info
}
```

3. **Different handling needed**
```java
// Different recovery strategies
try {
    processOrder();
} catch (PaymentFailedException e) {
    retry();
} catch (InvalidProductException e) {
    notifyUser();
}
```

4. **Clearer API**
```java
// Clear from method signature what can go wrong
public void transferMoney(Account from, Account to, double amount)
    throws InsufficientBalanceException,
           InvalidAccountException,
           TransferLimitExceededException {
    // Implementation
}
```

---

### Q11: Why does Spring rollback transactions for unchecked but not checked exceptions?

**Answer:**

**Spring's reasoning:**

**Unchecked exceptions** = Unexpected errors (bugs)
- Indicate something went wrong that wasn't planned for
- System is in unknown state
- **Safe to rollback** - don't commit partial work

**Checked exceptions** = Expected scenarios
- Part of normal business flow
- You explicitly handle them
- **You decide** whether to rollback

**Example:**
```java
@Transactional
public void processOrder(Order order) {
    orderRepository.save(order);
    
    // Unchecked - automatic rollback
    if (order.getTotal() < 0) {
        throw new IllegalStateException("Invalid total");
        // Transaction rolls back automatically
    }
    
    // Checked - no automatic rollback
    try {
        emailService.send(order);
    } catch (EmailException e) {
        // Transaction NOT rolled back
        // Email failure shouldn't cancel order
        logger.warn("Email failed but order saved");
    }
}
```

**To override:**
```java
@Transactional(rollbackFor = EmailException.class)
// Now EmailException also causes rollback

@Transactional(noRollbackFor = IllegalStateException.class)
// Now IllegalStateException won't cause rollback
```

---

### Q12: What's the difference between Error and Exception?

**Answer:**

| Error | Exception |
|-------|-----------|
| System-level problems | Application-level problems |
| Shouldn't be caught | Should be handled |
| Unrecoverable | Recoverable |
| Examples: OutOfMemoryError, StackOverflowError | Examples: IOException, NullPointerException |
| Extends Error class | Extends Exception class |

**Hierarchy:**
```
Throwable
├── Error (Don't catch)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── VirtualMachineError
│
└── Exception (Catch and handle)
    ├── RuntimeException (Unchecked)
    └── Other exceptions (Checked)
```

**Why not catch Error:**
```java
// Bad - don't do this
try {
    // code
} catch (OutOfMemoryError e) {
    // What can you even do? JVM is out of memory!
}

// Good - catch specific exceptions
try {
    // code
} catch (IOException e) {
    // Handle file error
}
```

---

### Q13: Explain the exception hierarchy in Java.

**Answer:**

```
java.lang.Throwable
│
├── java.lang.Error
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   ├── VirtualMachineError
│   └── AssertionError
│
└── java.lang.Exception
    │
    ├── java.lang.RuntimeException (Unchecked)
    │   ├── NullPointerException
    │   ├── IllegalArgumentException
    │   │   └── NumberFormatException
    │   ├── IllegalStateException
    │   ├── IndexOutOfBoundsException
    │   │   └── ArrayIndexOutOfBoundsException
    │   ├── ArithmeticException
    │   ├── ClassCastException
    │   └── UnsupportedOperationException
    │
    └── Other Exceptions (Checked)
        ├── IOException
        │   ├── FileNotFoundException
        │   └── EOFException
        ├── SQLException
        ├── ClassNotFoundException
        ├── InterruptedException
        └── ParseException
```

**Key points:**
- **Throwable** is the root
- **Error** for system issues (don't catch)
- **Exception** for application issues (catch)
- **RuntimeException** for programming errors (unchecked)
- Other exceptions are checked

---

## Quick Reference Cheat Sheet

### Exception Types Quick Guide

```java
// Checked - must handle
try {
    new FileReader("file.txt");
} catch (FileNotFoundException e) {
    // Must catch or declare
}

// Unchecked - optional to handle
int result = 10 / 0; // ArithmeticException - no forced handling
```

### Try-Catch-Finally Pattern

```java
try {
    // Code that may throw exception
} catch (SpecificException e) {
    // Handle specific exception
} catch (Exception e) {
    // Handle general exception
} finally {
    // Always executes - cleanup code
}
```

### Try-with-Resources

```java
try (Resource r1 = new Resource1();
     Resource r2 = new Resource2()) {
    // Use resources
} // Automatically closed in reverse order
```

### Custom Exception Template

```java
// Checked
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
    
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Unchecked
public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String message) {
        super(message);
    }
}
```

### Common Exception Scenarios

```java
// File operations
try (FileReader r = new FileReader("file.txt")) {
    // Read file
} catch (FileNotFoundException e) {
    // File doesn't exist
} catch (IOException e) {
    // Error reading file
}

// Null checking
if (obj == null) {
    throw new IllegalArgumentException("Object cannot be null");
}

// Validation
if (age < 0) {
    throw new IllegalArgumentException("Age must be positive");
}

// State checking
if (account.isClosed()) {
    throw new IllegalStateException("Account is closed");
}
```

---

## Key Takeaways for Interviews

1. **Checked vs Unchecked:**
   - Checked = external problems, must handle
   - Unchecked = programming bugs, optional to handle

2. **When to use which:**
   - Checked for expected business scenarios
   - Unchecked for programmer errors

3. **In Spring:**
   - Type determines HTTP status code
   - Type affects transaction rollback
   - Type influences logging strategy

4. **Best practices:**
   - Catch specific exceptions
   - Don't swallow exceptions
   - Clean up resources (use try-with-resources)
   - Fail fast with meaningful messages

5. **throw vs throws:**
   - throw = actually throw an exception object
   - throws = declare method might throw

6. **finally always executes:**
   - Even with return in try/catch
   - Use for cleanup operations
   - Or use try-with-resources

---

## Conclusion

Exception handling is crucial for building robust Java applications. Understanding the difference between checked and unchecked exceptions, when to use each type, and how to handle them properly will make you a better developer and help you ace technical interviews.

**Remember:** 
- Checked exceptions for recoverable conditions
- Unchecked exceptions for programming errors
- Always clean up resources
- Provide meaningful error messages
- In Spring, exception type matters for HTTP status, transactions, and logging

**In interviews, emphasize:**
> "Exception handling isn't just about preventing crashes—it's about designing clear APIs, handling business scenarios appropriately, and making systems more maintainable and debuggable."