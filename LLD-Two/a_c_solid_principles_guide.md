# SOLID Principles - Quick Interview Reference

## S - Single Responsibility Principle (SRP)

**Core Idea:** A class should have only ONE reason to change.

**How to Identify Violation:**
- Can you describe the class in one sentence without using "and"?
- Would changes from different business departments touch this class?
- Multiple unrelated method groups?

**Litmus Test:** Ask: "Who would request changes to this code?"
- Multiple different teams/stakeholders → **SRP violation**

**Fix:** Create separate classes for each responsibility.

**Example:**
```java
// ❌ VIOLATION
class Bird {
    String name;
    
    void eat() { }
    void sleep() { }
    
    // Multiple responsibilities in one class:
    void saveToDatabase() { }  // DB responsibility
    void displayOnScreen() { }  // UI responsibility
}

// ✅ FIXED
class Bird {
    String name;
    void eat() { }
    void sleep() { }
}

class BirdRepository {
    void save(Bird bird) { }
}

class BirdDisplay {
    void show(Bird bird) { }
}
```
```java
// ❌ VIOLATION - One method doing too many things
class UserService {
    public void saveToDatabase(User user) {
        // Connect to database
        Connection conn = DriverManager.getConnection(url, user, pwd);
        // Create a query
        String query = "INSERT INTO users VALUES (?, ?)";
        // Execute the query
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        // Close the connection
        conn.close();
    }
}

// ✅ FIXED - Each class has ONE responsibility
class DatabaseConnection {
    public Connection connect() {
        // Only responsible for connection management
        return DriverManager.getConnection(url, user, pwd);
    }
    
    public void close(Connection conn) {
        // Only responsible for cleanup
        conn.close();
    }
}

class UserRepository {
    private DatabaseConnection dbConnection;
    
    public UserRepository(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    
    public void save(User user) {
        // Only responsible for user persistence
        Connection conn = dbConnection.connect();
        String query = "INSERT INTO users VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getEmail());
        stmt.executeUpdate();
        dbConnection.close(conn);
    }
}

class UserService {
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void saveUser(User user) {
        // Only responsible for business logic
        userRepository.save(user);
    }
}
```

---

## O - Open/Closed Principle (OCP)

**Core Idea:** Open for extension, closed for modification.

**How to Identify Violation:**
- Giant if-else or switch statements for types
- Adding new feature requires modifying existing code
- Type checking with `instanceof`

**Litmus Test:** "If I add a new type/feature, do I have to modify existing code?"
- YES → **OCP violation**
- NO → Compliant

**Fix:** Use Strategy Pattern / Factory Pattern / Polymorphism

**Example:**
```java
// ❌ VIOLATION
class Bird {
    String type;
    
    void makeSound() {
        if (type.equals("Sparrow")) {
            System.out.println("Chirp");
        } else if (type.equals("Duck")) {
            System.out.println("Quack");
        }
        // Adding Parrot? Must modify this method!
    }
}

// ✅ FIXED
interface Bird {
    void makeSound();
}

class Sparrow implements Bird {
    void makeSound() { System.out.println("Chirp"); }
}

class Duck implements Bird {
    void makeSound() { System.out.println("Quack"); }
}

class Parrot implements Bird {
    void makeSound() { System.out.println("Squawk"); }
}
```

---

## L - Liskov Substitution Principle (LSP)

**Core Idea:** We should be able to substitute the subtypes to their base types without breaking behavior.

**How to Identify Violation:**
- Throwing exceptions in overridden methods
- Empty or no-op implementations
- Strengthening preconditions in child
- Need `instanceof` checks before using objects

**Litmus Test:** "Can I replace the parent with the child everywhere without surprises?"
- If you need `instanceof` checks → **LSP violation**
- If child throws exceptions parent doesn't → **LSP violation**
- If child has stricter rules → **LSP violation**

**Fix:** Strategy pattern (consider composition over inheritance) or fix inheritance hierarchy

**Example:**
```java
// ❌ VIOLATION
class Bird {
    void fly() { System.out.println("Flying"); }
}

class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException("Can't fly!");
    }
}

// ✅ FIXED
class Bird { 
    String name; 
    String color; 
    int wingSpan; 
    void makeSound(); 
}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {
    void fly() { System.out.println("Sparrow is Flying"); }
}

class Penguin extends Bird {
    // No fly method - correctly modeled
}

```

---

## I - Interface Segregation Principle (ISP)

**Core Idea:** Interfaces should be lightweight. i.e., less no of methods. (SRP for interfaces)

**How to Identify Violation:**
- Fat interfaces with many methods (> 5 unrelated methods)
- Implementing interface with empty/exception methods
- Clients forced to implement methods they'll never use

**Litmus Test:** "Am I forced to implement methods I'll never use or that don't make sense?"
- YES → **ISP violation**
- Look for empty implementations or exceptions → **ISP violation**

**Fix:** Split into multiple lightweight interfaces (Multiple Inheritance of interfaces)

**Example:**
```java
// ❌ VIOLATION
interface Bird {
    void fly();
    void swim();
    void eat();
}

class Sparrow implements Bird {
    void fly() { System.out.println("Flying"); }
    void swim() { throw new UnsupportedOperationException(); }
    void eat() { System.out.println("Eating"); }
}

// ✅ FIXED
interface Bird {
    void eat();
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Sparrow implements Bird, Flyable {
    void eat() { System.out.println("Eating"); }
    void fly() { System.out.println("Flying"); }
}

class Duck implements Bird, Flyable, Swimmable {
    void eat() { System.out.println("Eating"); }
    void fly() { System.out.println("Flying"); }
    void swim() { System.out.println("Swimming"); }
}
```

---

## D - Dependency Inversion Principle (DIP)

**Core Idea:** Depend on abstractions, not concretions. High-level modules shouldn't depend on low-level modules.

**How to Identify Violation:**
- Direct instantiation with `new` keyword in business logic
- Importing concrete implementation classes
- Cannot swap implementations easily
- Testing requires real database/network/filesystem

**Litmus Test:** "Can I easily swap this dependency for testing or different implementation?"
- NO → **DIP violation**
- See `new` in business logic → **DIP violation**
- Importing concrete classes → **DIP violation**

**Fix:** Code to interfaces + Dependency Injection

**Example:**
```java
// ❌ VIOLATION
class UserService {
    private MySQLDatabase db = new MySQLDatabase(); // Concrete!
    void save(User u) { db.save(u); }
}

// ✅ FIXED
interface Database { void save(User u); }
class UserService {
    private Database db; // Abstract!
    UserService(Database db) { this.db = db; } // DI
    void save(User u) { db.save(u); }
}
// Usage:
new UserService(new MySQLDatabase());
new UserService(new MockDatabase()); // Easy testing!
```

---

## Quick Reference Table

| Principle | Litmus Test Question | Red Flag | Fix |
|-----------|---------------------|----------|-----|
| **SRP** | "How many reasons to change?" | Multiple teams care about this class | Split into separate classes |
| **OCP** | "Modify existing code for new feature?" | if-else for types, instanceof | Strategy/Factory Pattern |
| **LSP** | "Can child replace parent everywhere?" | Exceptions in override, instanceof checks | Fix inheritance hierarchy |
| **ISP** | "Forced to implement unused methods?" | Empty methods, > 5 unrelated methods | Split into smaller interfaces |
| **DIP** | "Can I swap this dependency easily?" | `new` keyword, concrete imports | Interface + Dependency Injection |

---

## Interview Pro Tips

1. **Go through this checklist mentally** when analyzing any class (takes 30 seconds)
2. **Start with SRP** - it's the foundation, often fixes other violations
3. **Look for patterns**: `new`, `instanceof`, `if-else type checking`, empty methods
4. **Think about testing**: If hard to test → likely DIP violation
5. **Ask "who cares?"**: Different stakeholders → SRP violation