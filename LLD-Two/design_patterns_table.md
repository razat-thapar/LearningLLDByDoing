# Design Patterns Reference Guide

## Creational Patterns

### Singleton
**Intent:** Ensure a class has only one instance and provide global access to it

**When to Use:**
- Need exactly one instance (e.g., Logger, Config)
- Control concurrent access to shared resource
- Global point of access needed

**Structure:**
```
┌─────────────────┐
│   Singleton     │
├─────────────────┤
│ -instance       │
├─────────────────┤
│ +getInstance()  │
└─────────────────┘
```

**Example:**
```java
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

**Notes:** Thread-safe implementation needed, Double-checked locking, Eager vs Lazy initialization

---

### Factory Method
**Intent:** Define interface for creating objects, let subclasses decide which class to instantiate

**When to Use:**
- Class can't anticipate type of objects to create
- Want to delegate instantiation to subclasses
- Need flexibility in object creation

**Structure:**
```
    ┌──────────┐
    │ Creator  │
    ├──────────┤
    │+create() │◄─────┐
    └──────────┘      │
         △            │
         │            │creates
         │            │
┌────────┴─────────┐  │
│ ConcreteCreator  │  │
├──────────────────┤  │
│+create()         │──┘
└──────────────────┘
         │
         │ returns
         ▼
    ┌─────────┐
    │ Product │
    └─────────┘
```

**Example:**
```java
interface Product {}

abstract class Creator {
    abstract Product factoryMethod();
}

class ConcreteCreator extends Creator {
    Product factoryMethod() {
        return new ConcreteProduct();
    }
}
```

**Notes:** Promotes loose coupling, Open/Closed Principle, Subclass decides instantiation

---

### Abstract Factory
**Intent:** Provide interface for creating families of related objects without specifying concrete classes

**When to Use:**
- System independent of product creation
- Need to create families of related objects
- Want to enforce constraints on related objects

**Structure:**
```
┌──────────────────┐
│ AbstractFactory  │
├──────────────────┤
│+createProductA() │
│+createProductB() │
└──────────────────┘
         △
         │
┌────────┴─────────┐
│ ConcreteFactory  │
├──────────────────┤
│+createProductA() │──► ProductA1
│+createProductB() │──► ProductB1
└──────────────────┘
```

**Example:**
```java
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    Button createButton() { return new WinButton(); }
    Checkbox createCheckbox() { return new WinCheckbox(); }
}
```

**Notes:** Creates product families, Ensures compatibility, Easy to add new families

---

### Builder
**Intent:** Separate construction from representation

**When to Use:**
- Complex object creation with many optional parts
- Want immutable objects
- Construction process must allow different representations

**Structure:**
```
┌─────────┐      ┌─────────┐
│Director │─────►│ Builder │
└─────────┘      ├─────────┤
                 │+buildA()│
                 │+buildB()│
                 │+getResult()
                 └─────────┘
                      △
                      │
              ┌───────┴────────┐
              │ConcreteBuilder │
              ├────────────────┤
              │+buildA()       │
              │+buildB()       │──►Product
              │+getResult()    │
              └────────────────┘
```

**Example:**
```java
class Pizza {
    private String dough;
    private String sauce;
    
    public static class Builder {
        private String dough;
        
        public Builder dough(String d) {
            dough = d;
            return this;
        }
        
        public Pizza build() {
            return new Pizza(this);
        }
    }
}
```

**Notes:** Fluent interface, Step-by-step construction, Creates immutable objects, Method chaining

---

### Prototype
**Intent:** Create new objects by copying prototypical instance

**When to Use:**
- Object creation is expensive
- Want to avoid subclasses of creator
- Runtime specification of objects

**Structure:**
```
┌───────────┐
│ Prototype │
├───────────┤
│+clone()   │
└───────────┘
     △
     │
┌────┴──────────┐
│ConcreteProto  │
├───────────────┤
│+clone()       │──►returns copy of self
└───────────────┘
```

**Example:**
```java
interface Prototype {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    public Prototype clone() {
        return new ConcretePrototype(this);
    }
}
```

**Notes:** Clone existing objects, Deep vs Shallow copy, Reduces subclassing

---

## Structural Patterns

### Adapter
**Intent:** Convert interface of class into another interface clients expect

**When to Use:**
- Want to use existing class with incompatible interface
- Need to create reusable class with unrelated classes
- Legacy code integration

**Structure:**
```
┌────────┐      ┌─────────┐
│ Client │─────►│ Target  │
└────────┘      ├─────────┤
                │request()│
                └─────────┘
                     △
                     │
                ┌────┴────┐
                │ Adapter │───►┌─────────┐
                ├─────────┤    │ Adaptee │
                │request()│    ├─────────┤
                └─────────┘    │specific │
                               │Request()│
                               └─────────┘
```

**Example:**
```java
interface Target {
    void request();
}

class Adaptee {
    void specificRequest() {}
}

class Adapter implements Target {
    private Adaptee adaptee;
    
    void request() {
        adaptee.specificRequest();
    }
}
```

**Notes:** Class adapter vs Object adapter, Wrapper pattern, Two-way adapters possible

---

### Bridge
**Intent:** Decouple abstraction from implementation

**When to Use:**
- Want to avoid permanent binding between abstraction and implementation
- Both abstraction and implementation should be extensible
- Changes in implementation shouldn't affect clients

**Structure:**
```
┌──────────────┐
│ Abstraction  │
├──────────────┤      ┌───────────────┐
│+operation()  │─────►│ Implementor   │
└──────────────┘      ├───────────────┤
       △              │+operationImpl()│
       │              └───────────────┘
       │                      △
┌──────┴──────┐               │
│RefinedAbstr │         ┌─────┴──────┐
└─────────────┘         │ConcreteImpl│
                        └────────────┘
```

**Example:**
```java
interface Implementor {
    void operationImpl();
}

abstract class Abstraction {
    protected Implementor impl;
    
    void operation() {
        impl.operationImpl();
    }
}
```

**Notes:** Separates interface from implementation, Platform independence, Reduces compile-time dependencies

---

### Composite
**Intent:** Compose objects into tree structures to represent part-whole hierarchies

**When to Use:**
- Want to represent part-whole hierarchies
- Want clients to treat individual objects and compositions uniformly
- Recursive structures needed

**Structure:**
```
    ┌───────────┐
    │ Component │
    ├───────────┤
    │+operation()│
    └───────────┘
         △
         │
    ┌────┴─────┐
    │          │
┌───┴───┐  ┌──┴────────┐
│ Leaf  │  │ Composite │
├───────┤  ├───────────┤
│+oper()│  │+add()     │
└───────┘  │+remove()  │
           │+oper()    │
           └───────────┘
              │ contains
              ▼
           Component*
```

**Example:**
```java
interface Component {
    void operation();
}

class Leaf implements Component {
    void operation() {}
}

class Composite implements Component {
    List<Component> children;
    
    void operation() {
        for (Component c : children)
            c.operation();
    }
}
```

**Notes:** Tree structures, Uniform treatment, File system example

---

### Decorator
**Intent:** Attach additional responsibilities to object dynamically

**When to Use:**
- Want to add responsibilities without subclassing
- Responsibilities can be withdrawn
- Extension by subclassing is impractical

**Structure:**
```
┌───────────┐
│ Component │
├───────────┤
│+operation()│
└───────────┘
     △
     │
     ├──────────────┬───────────────┐
     │              │               │
┌────┴──────┐  ┌───┴─────────┐     │
│Concrete   │  │  Decorator  │─────┘
│Component  │  ├─────────────┤ wraps
└───────────┘  │+operation() │
               └─────────────┘
                     △
                     │
              ┌──────┴─────────┐
              │ConcreteDecorator│
              ├────────────────┤
              │+operation()    │
              └────────────────┘
```

**Example:**
```java
interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    void operation() {}
}

class Decorator implements Component {
    private Component component;
    
    void operation() {
        component.operation();
        // Add behavior
    }
}
```

**Notes:** Flexible alternative to subclassing, Responsibilities added at runtime, Java I/O streams example

---

### Facade
**Intent:** Provide unified interface to set of interfaces in subsystem

**When to Use:**
- Want simple interface to complex subsystem
- Many dependencies between clients and implementation
- Want to layer subsystems

**Structure:**
```
┌────────┐        ┌─────────┐
│ Client │───────►│ Facade  │
└────────┘        ├─────────┤
                  │+method()│
                  └─────────┘
                       │
            ┌──────────┼──────────┐
            ▼          ▼          ▼
      ┌──────────┐ ┌──────┐ ┌──────┐
      │SubsystemA│ │SysB  │ │SysC  │
      └──────────┘ └──────┘ └──────┘
```

**Example:**
```java
class Facade {
    private SubsystemA a;
    private SubsystemB b;
    
    void operation() {
        a.operationA();
        b.operationB();
    }
}
```

**Notes:** Simplifies interface, Reduces coupling, Doesn't prevent access to subsystem

---

### Flyweight
**Intent:** Use sharing to support large numbers of fine-grained objects efficiently

**When to Use:**
- Application uses large number of objects
- Storage costs are high
- Most object state can be extrinsic
- Many groups can be replaced by fewer shared objects

**Structure:**
```
┌────────────────┐
│FlyweightFactory│
├────────────────┤
│+getFlyweight() │──►Pool[key→Flyweight]
└────────────────┘
         │
         │creates/returns
         ▼
   ┌──────────┐
   │Flyweight │
   ├──────────┤
   │intrinsic │
   │state     │
   └──────────┘
```

**Example:**
```java
class Flyweight {
    private String intrinsicState;
    
    void operation(String extrinsicState) {}
}

class FlyweightFactory {
    Map<String, Flyweight> pool;
    
    Flyweight getFlyweight(String key) {
        if (!pool.contains(key))
            pool.put(key, new Flyweight());
        return pool.get(key);
    }
}
```

**Notes:** Intrinsic vs Extrinsic state, Object pooling, Memory optimization, String pool example

---

### Proxy
**Intent:** Provide surrogate or placeholder for another object to control access

**When to Use:**
- Need lazy initialization (Virtual Proxy)
- Need access control (Protection Proxy)
- Need remote access (Remote Proxy)
- Need additional functionality before/after access

**Structure:**
```
┌────────┐       ┌─────────┐
│ Client │──────►│ Subject │
└────────┘       ├─────────┤
                 │request()│
                 └─────────┘
                      △
                      │
          ┌───────────┴─────────────┐
          │                         │
    ┌─────┴───────┐         ┌───────┴──────┐
    │ RealSubject │         │    Proxy     │
    ├─────────────┤         ├──────────────┤
    │+request()   │         │+request()    │───►RealSubject
    └─────────────┘         └──────────────┘
```

**Example:**
```java
interface Subject {
    void request();
}

class RealSubject implements Subject {
    void request() {}
}

class Proxy implements Subject {
    private RealSubject realSubject;
    
    void request() {
        if (realSubject == null)
            realSubject = new RealSubject();
        realSubject.request();
    }
}
```

**Notes:** Virtual, Protection, Remote proxies, Lazy loading, Access control, Smart references

---

## Behavioral Patterns

### Chain of Responsibility
**Intent:** Avoid coupling sender to receiver by giving multiple objects chance to handle request

**When to Use:**
- More than one object may handle request
- Handler not known a priori
- Set of handlers should be specified dynamically

**Structure:**
```
┌────────┐      ┌─────────┐
│ Client │─────►│ Handler │
└────────┘      ├─────────┤
                │+handle()│───►next
                └─────────┘
                     △
                     │
           ┌─────────┴─────────┐
           │                   │
    ┌──────┴───────┐    ┌──────┴───────┐
    │ConcreteH1    │    │ConcreteH2    │
    ├──────────────┤    ├──────────────┤
    │+handle()     │    │+handle()     │
    └──────────────┘    └──────────────┘
```

**Example:**
```java
abstract class Handler {
    protected Handler next;
    
    void setNext(Handler h) { next = h; }
    
    void handleRequest(Request r) {
        if (canHandle(r)) process(r);
        else if (next != null) next.handleRequest(r);
    }
}
```

**Notes:** Decouples sender and receiver, Chain of handlers, Request passes until handled

---

### Command
**Intent:** Encapsulate request as object

**When to Use:**
- Need to parameterize objects with operations
- Want to queue, log, or support undo
- Need to support transactions

**Structure:**
```
┌────────┐      ┌─────────┐
│Invoker │─────►│ Command │
└────────┘      ├─────────┤
                │+execute()│
                └─────────┘
                     △
                     │
              ┌──────┴──────┐
              │ConcreteCmd  │
              ├─────────────┤───►┌──────────┐
              │+execute()   │    │ Receiver │
              └─────────────┘    └──────────┘
```

**Example:**
```java
interface Command {
    void execute();
    void undo();
}

class ConcreteCommand implements Command {
    private Receiver receiver;
    
    void execute() {
        receiver.action();
    }
}
```

**Notes:** Undo/Redo operations, Macro commands, Transaction support, Request queuing

---

### Iterator
**Intent:** Provide way to access elements sequentially without exposing underlying representation

**When to Use:**
- Need to access aggregate's contents without exposing internal structure
- Support multiple traversals
- Provide uniform interface for different structures

**Structure:**
```
┌───────────┐         ┌──────────┐
│ Aggregate │◄────────│ Iterator │
├───────────┤         ├──────────┤
│+create    │         │+hasNext()│
│Iterator() │         │+next()   │
└───────────┘         └──────────┘
     △                      △
     │                      │
┌────┴────────┐      ┌──────┴──────────┐
│ConcreteAggr │      │ConcreteIterator │
└─────────────┘      └─────────────────┘
```

**Example:**
```java
interface Iterator<T> {
    boolean hasNext();
    T next();
}

interface Aggregate<T> {
    Iterator<T> createIterator();
}
```

**Notes:** Hides internal structure, Multiple iterators possible, Java Iterator interface

---

### Mediator
**Intent:** Define object that encapsulates how set of objects interact

**When to Use:**
- Objects communicate in complex ways
- Want to reuse objects without dependencies
- Behavior distributed between classes should be customizable

**Structure:**
```
┌───────────┐
│ Mediator  │
├───────────┤
│+notify()  │
└───────────┘
     △
     │
┌────┴──────────┐
│ConcreteMediator│◄───────┐
└───────────────┘        │
     △                   │
     │                   │
     │    ┌──────────────┴───────────┐
     └────│Component1  Component2    │
          └──────────────────────────┘
```

**Example:**
```java
class Mediator {
    void notify(Component sender, String event) {
        if (event.equals("A")) {
            // coordinate components
        }
    }
}

class Component {
    private Mediator mediator;
    
    void operation() {
        mediator.notify(this, "A");
    }
}
```

**Notes:** Centralizes control, Reduces coupling, Simplifies protocols, Can become complex

---

### Memento
**Intent:** Capture and externalize object's internal state for later restoration

**When to Use:**
- Need to save/restore object state
- Direct interface violates encapsulation

**Structure:**
```
┌───────────┐    creates    ┌─────────┐
│Originator │──────────────►│ Memento │
├───────────┤               ├─────────┤
│+save()    │               │ state   │
│+restore() │◄──────────────└─────────┘
└───────────┘    restores
     △
     │
     │stores
┌────┴─────┐
│Caretaker │
└──────────┘
```

**Example:**
```java
class Memento {
    private String state;
    Memento(String s) { state = s; }
    String getState() { return state; }
}

class Originator {
    private String state;
    
    Memento save() {
        return new Memento(state);
    }
    
    void restore(Memento m) {
        state = m.getState();
    }
}
```

**Notes:** Undo mechanism, Snapshot of state, Preserves encapsulation

---

### Observer
**Intent:** Define one-to-many dependency so when one object changes state, all dependents are notified

**When to Use:**
- Abstraction has two aspects, one dependent on other
- Change to one object requires changing others
- Object should notify others without assumptions

**Structure:**
```
┌─────────┐         ┌──────────┐
│ Subject │◄────────│ Observer │
├─────────┤         ├──────────┤
│+attach()│         │+update() │
│+detach()│         └──────────┘
│+notify()│              △
└─────────┘              │
     △                   │
     │          ┌────────┴────────┐
     │          │                 │
┌────┴──────┐   │ConcreteObs1    ConcreteObs2
│ConcreteSubj│   └─────────────────┘
└───────────┘
```

**Example:**
```java
interface Observer {
    void update();
}

class Subject {
    List<Observer> observers;
    
    void attach(Observer o) {
        observers.add(o);
    }
    
    void notifyObservers() {
        for (Observer o : observers)
            o.update();
    }
}
```

**Notes:** Publish-Subscribe, Event handling, Loose coupling, Push vs Pull models

---

### State
**Intent:** Allow object to alter behavior when internal state changes

**When to Use:**
- Object behavior depends on state
- Operations have large conditional statements based on state

**Structure:**
```
┌─────────┐         ┌───────┐
│ Context │────────►│ State │
├─────────┤         ├───────┤
│+request()│        │+handle()│
└─────────┘         └───────┘
                        △
                        │
              ┌─────────┴─────────┐
              │                   │
       ┌──────┴──────┐     ┌──────┴──────┐
       │ConcreteStateA│    │ConcreteStateB│
       ├─────────────┤     ├─────────────┤
       │+handle()    │     │+handle()    │
       └─────────────┘     └─────────────┘
```

**Example:**
```java
interface State {
    void handle();
}

class Context {
    private State state;
    
    void setState(State s) { state = s; }
    
    void request() {
        state.handle();
    }
}
```

**Notes:** State-specific behavior, Eliminates conditionals, State transitions explicit

---

### Strategy
**Intent:** Define family of algorithms, encapsulate each one, make them interchangeable

**When to Use:**
- Many related classes differ only in behavior
- Need different variants of algorithm
- Algorithm uses data clients shouldn't know about

**Structure:**
```
┌─────────┐         ┌──────────┐
│ Context │────────►│ Strategy │
├─────────┤         ├──────────┤
│+execute()│        │+algorithm()│
└─────────┘         └──────────┘
                         △
                         │
           ┌─────────────┼─────────────┐
           │             │             │
    ┌──────┴──────┐ ┌────┴────┐ ┌──────┴──────┐
    │StrategyA    │ │StrategyB│ │StrategyC    │
    ├─────────────┤ ├─────────┤ ├─────────────┤
    │+algorithm() │ │+algorithm│ │+algorithm() │
    └─────────────┘ └─────────┘ └─────────────┘
```

**Example:**
```java
interface Strategy {
    void execute();
}

class Context {
    private Strategy strategy;
    
    void setStrategy(Strategy s) {
        strategy = s;
    }
    
    void doOperation() {
        strategy.execute();
    }
}
```

**Notes:** Eliminates conditionals, Runtime algorithm selection, Alternative to subclassing

---

### Template Method
**Intent:** Define skeleton of algorithm, let subclasses redefine certain steps

**When to Use:**
- Want to implement invariant parts once
- Common behavior should be factored and localized
- Control subclass extensions

**Structure:**
```
┌──────────────────┐
│ AbstractClass    │
├──────────────────┤
│+templateMethod() │ (final)
│+primitiveOp1()   │ (abstract)
│+primitiveOp2()   │ (abstract)
└──────────────────┘
         △
         │
┌────────┴────────┐
│ ConcreteClass   │
├─────────────────┤
│+primitiveOp1()  │
│+primitiveOp2()  │
└─────────────────┘
```

**Example:**
```java
abstract class AbstractClass {
    final void templateMethod() {
        primitiveOp1();
        primitiveOp2();
    }
    
    abstract void primitiveOp1();
    abstract void primitiveOp2();
}
```

**Notes:** Code reuse, Hook methods, Hollywood Principle, Inversion of control

---

### Visitor
**Intent:** Represent operation to be performed on elements of object structure

**When to Use:**
- Object structure contains many classes with different interfaces
- Many distinct operations to be performed
- Structure rarely changes but operations do

**Structure:**
```
┌─────────┐          ┌─────────┐
│ Element │          │ Visitor │
├─────────┤          ├─────────┤
│+accept()│          │+visitA()│
└─────────┘          │+visitB()│
     △               └─────────┘
     │                    △
     │                    │
┌────┴────┐         ┌─────┴────────┐
│ElementA │         │ConcreteVisitor│
├─────────┤         ├──────────────┤
│+accept()│────────►│+visitA()     │
└─────────┘  calls  │+visitB()     │
                    └──────────────┘
```

**Example:**
```java
interface Visitor {
    void visit(ElementA e);
    void visit(ElementB e);
}

interface Element {
    void accept(Visitor v);
}

class ElementA implements Element {
    void accept(Visitor v) {
        v.visit(this);
    }
}
```

**Notes:** Double dispatch, Add new operations easily, Hard to add new elements, Breaks encapsulation

---

## Quick Reference

### Pattern Selection by Problem

| Problem | Suggested Patterns |
|---------|-------------------|
| Too many if-else/switch statements | Strategy, State, Command, Chain of Responsibility |
| Need to add functionality without modifying code | Decorator, Strategy, Observer |
| Complex object creation | Builder, Abstract Factory, Factory Method |
| Need single instance | Singleton |
| Incompatible interfaces | Adapter, Facade |
| Undo/Redo functionality | Command, Memento |
| Notify multiple objects of changes | Observer |
| Simplify complex subsystem | Facade |
| Algorithms need to be interchangeable | Strategy |

### Pattern Selection by SOLID Principle

| SOLID Principle | Helpful Patterns |
|-----------------|------------------|
| Single Responsibility | Facade, Proxy, Command |
| Open/Closed | Strategy, Decorator, Observer, Template Method |
| Liskov Substitution | Strategy, Decorator, Bridge |
| Interface Segregation | Adapter, Facade |
| Dependency Inversion | Factory Method, Abstract Factory, Builder |