# JVM Architecture - Backend Interview Guide

## Overview
JVM (Java Virtual Machine) is an abstract machine that enables platform-independent execution of Java programs. It converts bytecode into native machine code.

**Key Concept**: Write Once, Run Anywhere (WORA) - Java applications are platform-independent because JVM handles platform-specific differences.

## JVM vs JRE vs JDK

- **JVM**: Executes Java bytecode
- **JRE**: JVM + Java class libraries + runtime components (superset of JVM)
- **JDK**: JRE + development tools (compiler, debugger, JavaDoc)

## Java Execution Flow

```
┌─────────────────────────────────────────────────────────────┐
│  JAVA SOURCE CODE (.java)                                    │
└───────────────────┬─────────────────────────────────────────┘
                    │
                    ▼
            ┌───────────────┐
            │ Java Compiler │
            │   (javac)     │
            └───────┬───────┘
                    │
                    ▼
┌─────────────────────────────────────────────────────────────┐
│  BYTECODE (.class) - Platform Independent                    │
└───────────────────┬─────────────────────────────────────────┘
                    │
                    ▼
        ┌───────────────────────┐
        │         JVM           │
        │  (Platform Specific)  │
        └───────────┬───────────┘
                    │
                    ▼
┌─────────────────────────────────────────────────────────────┐
│  MACHINE CODE - Executed by CPU                              │
└─────────────────────────────────────────────────────────────┘
```

## JVM Internal Architecture

```
┌──────────────────────────────────────────────────────────────┐
│                         JVM                                   │
├──────────────────────────────────────────────────────────────┤
│                                                               │
│  ┌────────────────────────────────────────────────────┐     │
│  │           CLASS LOADER SUBSYSTEM                    │     │
│  │  • Bootstrap  • Extension  • Application            │     │
│  │  (Loading → Linking → Initialization)               │     │
│  └────────────────────┬───────────────────────────────┘     │
│                       │                                       │
│                       ▼                                       │
│  ┌─────────────────────────────────────────────────────┐    │
│  │         RUNTIME DATA AREAS                           │    │
│  ├──────────────────────────────────────────────────────┤   │
│  │  ┌──────────────┐  ┌──────────────────────────┐     │   │
│  │  │ Method Area  │  │         Heap             │     │   │
│  │  │ (Class data) │  │  (Objects & Arrays)      │     │   │
│  │  │   [Shared]   │  │       [Shared]           │     │   │
│  │  └──────────────┘  └──────────────────────────┘     │   │
│  │                                                       │   │
│  │  ┌─────────────┐  ┌──────────┐  ┌────────────────┐ │   │
│  │  │  JVM Stack  │  │ PC Reg.  │  │ Native Method  │ │   │
│  │  │ (Thread 1)  │  │(Thread 1)│  │ Stack (T1)     │ │   │
│  │  └─────────────┘  └──────────┘  └────────────────┘ │   │
│  │  ┌─────────────┐  ┌──────────┐  ┌────────────────┐ │   │
│  │  │  JVM Stack  │  │ PC Reg.  │  │ Native Method  │ │   │
│  │  │ (Thread 2)  │  │(Thread 2)│  │ Stack (T2)     │ │   │
│  │  └─────────────┘  └──────────┘  └────────────────┘ │   │
│  │       [Per Thread Areas]                            │   │
│  └─────────────────────────────────────────────────────┘   │
│                       │                                      │
│                       ▼                                      │
│  ┌─────────────────────────────────────────────────────┐   │
│  │          EXECUTION ENGINE                            │   │
│  ├──────────────────────────────────────────────────────┤  │
│  │  ┌─────────────┐  ┌──────────────┐  ┌───────────┐  │  │
│  │  │ Interpreter │  │ JIT Compiler │  │  Garbage  │  │  │
│  │  │             │  │              │  │ Collector │  │  │
│  │  └─────────────┘  └──────────────┘  └───────────┘  │  │
│  └─────────────────────────────────────────────────────┘  │
│                       │                                     │
│                       ▼                                     │
│  ┌─────────────────────────────────────────────────────┐  │
│  │      NATIVE METHOD INTERFACE (JNI)                   │  │
│  └────────────────────┬────────────────────────────────┘  │
│                       │                                     │
└───────────────────────┼─────────────────────────────────────┘
                        │
                        ▼
              ┌──────────────────┐
              │ Native Libraries │
              │    (C/C++)       │
              └──────────────────┘
```

## JVM Architecture Components

### 1. Class Loader Subsystem
Loads class files into memory and performs three operations:
- **Loading**: Reads .class files
- **Linking**: Verifies bytecode, allocates memory for static variables
- **Initialization**: Executes static blocks and initializes static variables

### 2. Runtime Data Areas

**Method Area**
- Stores class-level data: metadata, static variables, static methods, constant pool
- Shared across all threads

**Heap**
- Stores objects and instance variables
- Created at JVM startup
- Shared across all threads
- Target of Garbage Collection

**JVM Stack**
- Thread-specific (one per thread)
- Stores local variables and partial results
- Frame created per method invocation
- LIFO structure

**PC (Program Counter) Register**
- Thread-specific
- Stores address of currently executing JVM instruction

**Native Method Stack**
- Stores native method information (C/C++)
- Used for JNI calls

### 3. Execution Engine

**Interpreter**
- Executes bytecode line by line
- Slower for repeated code

**JIT (Just-In-Time) Compiler**
- Compiles frequently executed bytecode (hot spots) to native machine code
- Improves performance significantly
- Enabled by default

**Garbage Collector**
- Automatic memory management
- Removes unreferenced objects from heap
- Two phases:
  - **Mark**: Identifies unused objects
  - **Sweep**: Removes marked objects

### 4. Native Method Interface (JNI)
- Framework allowing Java code to interact with native applications/libraries (C/C++)

### 5. Native Method Libraries
- Collection of C/C++ libraries required by the Execution Engine

## Common Interview Points

**Q: Why is Java platform-independent?**
Java compiler generates bytecode (not machine code), which JVM converts to platform-specific machine code.

**Q: What makes JVM fast?**
JIT compiler optimizes frequently executed code by compiling it to native machine code at runtime.

**Q: How does memory management work?**
- Stack: Method-level data, thread-specific, automatic cleanup
- Heap: Objects, shared across threads, managed by Garbage Collector

**Q: Difference between JDK and JRE?**
JDK = development (includes compiler, debugger) | JRE = runtime (executes Java programs)

## Key Takeaways
- JVM provides runtime environment and executes bytecode
- Class Loader loads classes dynamically
- Memory divided into Stack (thread-specific) and Heap (shared)
- JIT compiler enhances performance
- Garbage Collector handles automatic memory management