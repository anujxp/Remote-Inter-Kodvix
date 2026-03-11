# Java Learning Notes – Day Topic

Topics Covered

1. Java Basics
2. OOP Concepts
3. Object Copy Concepts
4. Static Keyword
5. Garbage Collector
6. JMM (Java Memory Model)

---

# 1. Java Basics

Java is a **high-level, object-oriented and platform independent programming language** developed by **Sun Microsystems (now Oracle)**.

Main feature of Java is:

```
Write Once Run Anywhere (WORA)
```

Java programs run on **JVM (Java Virtual Machine)** which converts bytecode into machine code.

### Java Program Flow

```
Java Code (.java)
      ↓
Compiler (javac)
      ↓
Bytecode (.class)
      ↓
JVM
      ↓
Machine Code
```

### Basic Structure of Java Program

```java
class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}
```

### Important Components

```
Class
Main Method
Objects
Methods
Variables
```

### Data Types in Java

Two categories:

#### Primitive Data Types

```
int
float
double
char
boolean
byte
short
long
```

#### Non Primitive

```
String
Array
Class
Interface
```

### Real Life Use Cases

Java is used in:

```
Android Development
Web Applications
Banking Systems
Enterprise Software
Backend Development
```

---

# 2. OOP Concepts

Java is based on **Object Oriented Programming (OOP)**.

OOP helps in:

```
Code Reusability
Security
Modularity
Maintainability
```

Main 4 pillars of OOP:

```
Encapsulation
Inheritance
Polymorphism
Abstraction
```

---

## 1 Encapsulation

Encapsulation means **binding data and methods together in a single unit (class)**.

Example:

```java
class Student {

    private int id;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

}
```

Benefit

```
Data hiding
Better security
```

---

## 2 Inheritance

Inheritance means **acquiring properties of another class**.

Example:

```java
class Animal {

    void eat(){
        System.out.println("Eating");
    }

}

class Dog extends Animal {

    void bark(){
        System.out.println("Barking");
    }

}
```

Types of Inheritance

```
Single
Multilevel
Hierarchical
```

(Java does not support multiple inheritance with classes)

---

## 3 Polymorphism

Polymorphism means **one method having multiple forms**.

Types

```
Compile Time Polymorphism (Method Overloading)
Run Time Polymorphism (Method Overriding)
```

Example

```java
class Calculator {

    int add(int a, int b){
        return a+b;
    }

    int add(int a, int b, int c){
        return a+b+c;
    }

}
```

---

## 4 Abstraction

Abstraction means **hiding implementation details and showing only essential features**.

Achieved using:

```
Abstract class
Interface
```

Example

```java
abstract class Vehicle {

    abstract void start();

}
```

---

# 3. Object Copy Concepts

Sometimes we need to **copy objects in Java**.

Two types of object copying:

```
Shallow Copy
Deep Copy
```

---

## Shallow Copy

In shallow copy:

```
Only references are copied
Both objects point to same memory
```

Example

```java
Student s1 = new Student();
Student s2 = s1;
```

Diagram

```
s1  ----|
        |----> Object (Heap)
s2  ----|
```

Problem:

If we change one object, the other also changes.

---

## Deep Copy

In deep copy:

```
New object is created
Memory is different
```

Example

```java
Student s1 = new Student();

Student s2 = new Student();
s2.id = s1.id;
```

Diagram

```
s1 ----> Object 1
s2 ----> Object 2
```

Real Use Case

```
Cloning objects
Copying configuration objects
Immutable objects
```

---

# 4. Static Keyword

`static` keyword belongs to **class rather than object**.

Meaning:

```
Single copy shared by all objects
```

Static can be used with:

```
Variables
Methods
Blocks
Nested Classes
```

---

## Static Variable

Shared among all objects.

Example

```java
class Student {

    static String college = "GHSC";

}
```

All students will share the same college.

---

## Static Method

Can be called **without creating object**.

Example

```java
class MathUtil {

    static int add(int a, int b){
        return a+b;
    }

}
```

Call:

```java
MathUtil.add(5,10);
```

---

## Static Block

Used for **initialization of static variables**.

Example

```java
class Test {

    static{
        System.out.println("Static Block Executed");
    }

}
```

Runs when **class is loaded into JVM**.

---

# 5. Garbage Collector

Garbage Collector automatically **removes unused objects from heap memory**.

Example

```java
Student s = new Student();

s = null;
```

Now object becomes **eligible for garbage collection**.

Important Points

```
Developer cannot force GC
JVM decides when to run it
```

---

## Types of GC

### Minor GC

Occurs in:

```
Young Generation
```

### Major GC

Occurs in:

```
Old Generation
```

### Full GC

Cleans:

```
Young Generation
Old Generation
Metaspace
```

Popular GC types

```
Serial GC
Parallel GC
CMS
G1 GC
```

---

# 6. JMM (Java Memory Model)

JMM defines **how threads interact with memory in Java**.

It describes:

```
How variables are stored in memory
How threads access shared variables
Rules for visibility and ordering
```

JMM ensures:

```
Thread safety
Memory consistency
Correct synchronization
```

---

## JMM Architecture

```
                Main Memory
             (Heap + Shared Data)

            /         |         \
           /          |          \
     Thread 1    Thread 2    Thread 3

        |             |            |
   Working        Working      Working
   Memory         Memory       Memory
```

Explanation

```
Main Memory → shared by all threads
Working Memory → private to each thread
```

Threads **read data from main memory to working memory** and then operate on it.

---

## JMM Rules

### Visibility

When one thread updates a variable, other threads must see the updated value.

Achieved using:

```
volatile
synchronized
```

---

### Happens Before Rule

Defines **order of execution between operations**.

Example:

```
Write operation happens-before read operation
```

---

## Example

```java
volatile boolean flag = true;
```

`volatile` ensures **changes are visible to all threads immediately**.

---

# Summary

Today I studied the following concepts:

```
Java Basics
OOP Concepts
Object Copy (Shallow vs Deep)
Static Keyword
Garbage Collection
Java Memory Model (JMM)
```

These concepts are very important for:

```
Java backend development
Multithreading
Performance optimization
Technical interviews
```

---

If you want, I can also create a **very impressive README style diagram section for your internship repo** that includes:

* **OOP relationship diagram**
* **Object memory diagram**
* **Garbage collection heap diagram**
* **Java Memory Model thread diagram**

It will make your **GitHub internship repo look like a senior developer project.**


# JVM Architecture (Java Virtual Machine)

## 1. Introduction

Java follows the concept **“Write Once Run Anywhere (WORA)”**.
This means that a Java program written on one platform can run on any platform without modification.

This portability is possible because of the **Java Virtual Machine (JVM)**.

When we write a Java program:

```
.java file  → compiled by javac → .class (Bytecode) → executed by JVM
```

The JVM converts **Java Bytecode into machine code** that the operating system can understand. ([GeeksforGeeks][1])

So JVM acts as a **runtime engine** that runs Java applications.

---

# 2. Relationship Between JDK, JRE and JVM

Before understanding JVM architecture, we must understand the relationship between **JDK, JRE and JVM**.

### JDK (Java Development Kit)

JDK is used to **develop Java applications**.

It contains:

* Java Compiler (javac)
* Java Debugger
* Development tools
* JRE

### JRE (Java Runtime Environment)

JRE provides the **environment to run Java programs**.

It contains:

* JVM
* Java Class Libraries
* Runtime files

### JVM (Java Virtual Machine)

JVM is the **core engine that executes Java bytecode**.

It converts bytecode into machine instructions.

---

# Diagram: JDK – JRE – JVM Relationship

```
+--------------------------------------------------+
|                     JDK                          |
|        (Java Development Kit)                    |
|                                                  |
|   +------------------------------------------+   |
|   |                  JRE                     |   |
|   |         (Java Runtime Environment)       |   |
|   |                                          |   |
|   |    +-------------------------------+     |   |
|   |    |             JVM               |     |   |
|   |    |     (Java Virtual Machine)    |     |   |
|   |    +-------------------------------+     |   |
|   |                                          |   |
|   |   Java Class Libraries + Runtime Files   |   |
|   +------------------------------------------+   |
|                                                  |
|   Development Tools: javac, javadoc, jar etc.    |
+--------------------------------------------------+
```

### Simple Way to Remember

```
JDK = JRE + Development Tools
JRE = JVM + Libraries
JVM = Engine that runs bytecode
```

---

# 3. JVM Architecture Overview

JVM architecture mainly consists of the following components:

1. Class Loader Subsystem
2. Runtime Data Areas (Memory)
3. Execution Engine
4. Java Native Interface (JNI)
5. Native Method Libraries

---

# Complete JVM Architecture Diagram

```
                     +----------------------+
                     |      Java Program    |
                     |        (.class)      |
                     +----------+-----------+
                                |
                                v
                     +----------------------+
                     |   Class Loader       |
                     |  (Loading Classes)   |
                     +----------+-----------+
                                |
                                v
                   +--------------------------+
                   |     Runtime Data Areas   |
                   |                          |
                   |  Method Area             |
                   |  Heap                    |
                   |  Stack                   |
                   |  PC Register             |
                   |  Native Method Stack     |
                   +-----------+--------------+
                               |
                               v
                     +-----------------------+
                     |    Execution Engine   |
                     |                       |
                     |  Interpreter          |
                     |  JIT Compiler         |
                     |  Garbage Collector    |
                     +-----------+-----------+
                                 |
                                 v
                     +-----------------------+
                     | Java Native Interface |
                     +-----------+-----------+
                                 |
                                 v
                     +-----------------------+
                     | Native Method Library |
                     +-----------------------+
```

---

# 4. Class Loader Subsystem

The **Class Loader** is responsible for loading the `.class` files into JVM memory.

It performs **three main operations**:

### 1. Loading

The class loader reads the **.class file (bytecode)** and loads it into memory.

### 2. Linking

Linking prepares the class for execution and consists of three steps:

#### a) Verification

* Checks whether bytecode is valid.
* Ensures security rules are followed.

#### b) Preparation

* Allocates memory for static variables.
* Default values are assigned.

#### c) Resolution

* Converts symbolic references into direct memory references.

### 3. Initialization

* Assigns actual values to static variables.
* Executes static blocks.

---

# Types of Class Loaders

There are **three types of class loaders**.

### 1. Bootstrap Class Loader

* Loads **core Java classes**
* Example: `java.lang`, `java.util`
* Located in `JAVA_HOME/lib`

### 2. Extension Class Loader

* Loads classes from extension directories
* Located in

```
JAVA_HOME/jre/lib/ext
```

### 3. Application (System) Class Loader

* Loads classes from **classpath**
* Loads user-defined classes

---

# 5. JVM Runtime Data Areas (Memory)

JVM memory is divided into **five main areas**. ([GeeksforGeeks][1])

---

# JVM Memory Architecture Diagram

```
                +------------------------------------+
                |         Runtime Data Area          |
                +------------------------------------+

                +------------- Method Area ----------+
                | Class Metadata                     |
                | Static Variables                   |
                | Method Information                 |
                | Runtime Constant Pool              |
                +------------------------------------+

                +--------------- Heap ---------------+
                | Objects                            |
                | Instance Variables                 |
                | Arrays                             |
                | Managed by Garbage Collector       |
                +------------------------------------+

                +--------------- Stack --------------+
Thread 1 -----> | Frame 1 (Method Call)              |
                | Frame 2                            |
                | Local Variables                    |
                | Operand Stack                      |
                +------------------------------------+

                +------------ PC Register -----------+
                | Address of Current Instruction     |
                +------------------------------------+

                +-------- Native Method Stack -------+
                | Native methods written in C/C++    |
                +------------------------------------+
```

---

# 1. Method Area

* Stores **class-level information**.
* Shared among all threads.
* Contains:

  * Class name
  * Methods
  * Static variables
  * Runtime constant pool

In Java 8+, this area is implemented using **Metaspace**.

---

# 2. Heap Area

Heap is used to store **objects and instance variables**.

Example:

```java
Student s = new Student();
```

The object `Student` is stored in the **Heap Memory**.

Characteristics:

* Shared across all threads
* Managed by **Garbage Collector**

Heap is divided into:

```
Young Generation
Old Generation
Survivor Space
```

---

# 3. Stack Area

Each thread has its own **stack memory**.

Every method call creates a **stack frame**.

Each frame contains:

```
Local Variables
Operand Stack
Frame Data
```

Example:

```
main()
   |
   |---- methodA()
            |
            |---- methodB()
```

Each method call creates a new stack frame.

---

# 4. Program Counter (PC Register)

Each thread has its own **PC register**.

It stores:

```
Address of current instruction being executed
```

---

# 5. Native Method Stack

Used to execute **native methods written in C or C++**.

Example:

```
System library calls
Operating system functions
```

---

# 6. Execution Engine

The **Execution Engine executes bytecode** loaded into memory.

Main components:

### 1. Interpreter

* Reads bytecode **line by line**
* Converts it to machine instructions
* Slower execution

### 2. JIT Compiler (Just In Time Compiler)

Improves performance.

Instead of interpreting repeatedly:

```
Bytecode → compiled into native machine code
```

This native code is reused.

JIT contains:

```
Code Optimizer
Profiler
Intermediate Code Generator
Target Code Generator
```

### 3. Garbage Collector (GC)

Automatically removes **unused objects from heap memory**.

Example:

```
Student s = new Student();
s = null;
```

Now the object becomes eligible for garbage collection.

---

# 7. Java Native Interface (JNI)

JNI allows Java programs to interact with **native libraries written in C or C++**.

Example:

```
Java → C Library → OS
```

---

# 8. Native Method Libraries

These are **platform-specific libraries** required by native methods.

Examples:

```
.dll files (Windows)
.so files (Linux)
```

---

# 9. Complete JVM Execution Flow

```
Step 1
Java Source Code
      |
      v
Step 2
Compiler (javac)
      |
      v
Step 3
Bytecode (.class)
      |
      v
Step 4
Class Loader
      |
      v
Step 5
Runtime Data Area (Memory Allocation)
      |
      v
Step 6
Execution Engine
   |       |        |
Interpreter JIT   GC
      |
      v
Step 7
Machine Code
      |
      v
Step 8
Program Output
```

---

# One-Line Interview Answer

**JVM is a runtime engine that loads, verifies, and executes Java bytecode using components like Class Loader, Runtime Data Areas, and Execution Engine.**


Below are **super interview-level handwritten notes** you can copy into your notebook or README.
I am writing it **like a student writing notes for interview preparation**, not like a teacher explanation.

---

# Advanced JVM Architecture (Interview Level)

In the JVM, memory is divided into multiple regions to efficiently manage program execution, object allocation, and garbage collection.

A Java program goes through the following stages:

```
Java Code → Bytecode → JVM → Execution Engine → Machine Code
```

To understand how JVM actually works internally, we must understand the **detailed JVM architecture** including:

* Class Loader
* Memory Areas
* Thread Stack
* Heap Generations
* JIT Compilation Pipeline
* Garbage Collection

---

# Complete JVM Architecture (Advanced Diagram)

```
                          +----------------------+
                          |   Java Source Code   |
                          +----------+-----------+
                                     |
                                     v
                          +----------------------+
                          |       javac          |
                          |   (Java Compiler)    |
                          +----------+-----------+
                                     |
                                     v
                          +----------------------+
                          |      Bytecode        |
                          |       (.class)       |
                          +----------+-----------+
                                     |
                                     v
                         +-----------------------+
                         |    Class Loader       |
                         |-----------------------|
                         | Bootstrap Loader      |
                         | Extension Loader      |
                         | Application Loader    |
                         +----------+------------+
                                    |
                                    v
                    =====================================
                    |        JVM Runtime Data Area      |
                    =====================================

     +---------------------------------------------------------------+
     |                           HEAP                                |
     |                                                               |
     |  +----------- Young Generation -----------------------------+ |
     |  |  Eden Space                                              | |
     |  |                                                          | |
     |  |  Survivor Space S0      Survivor Space S1                | |
     |  +----------------------------------------------------------+ |
     |                                                               |
     |  +----------- Old Generation (Tenured) --------------------+ |
     |  | Long living objects                                      | |
     |  +----------------------------------------------------------+ |
     +---------------------------------------------------------------+


     +---------------------------------------------------------------+
     |                        METASPACE                              |
     |---------------------------------------------------------------|
     | Class Metadata                                                |
     | Method Metadata                                               |
     | Runtime Constant Pool                                         |
     | Static Variables                                              |
     +---------------------------------------------------------------+


     +---------------------------------------------------------------+
     |                       THREAD STACKS                           |
     |---------------------------------------------------------------|
     | Thread 1 Stack                                                |
     |   Frame 1 : Method Call                                       |
     |   Frame 2 : Local Variables                                   |
     |   Frame 3 : Operand Stack                                     |
     |                                                               |
     | Thread 2 Stack                                                |
     |   Frame 1                                                     |
     |   Frame 2                                                     |
     +---------------------------------------------------------------+


     +---------------------------------------------------------------+
     |                       PC REGISTER                             |
     | Stores address of currently executing instruction             |
     +---------------------------------------------------------------+


     +---------------------------------------------------------------+
     |                    NATIVE METHOD STACK                        |
     | Used for C / C++ native calls                                 |
     +---------------------------------------------------------------+

                                     |
                                     v

                         +-----------------------------+
                         |      Execution Engine       |
                         +-------------+---------------+
                                       |
            --------------------------------------------------------
            |                        |                            |
            v                        v                            v

     +-------------+        +-------------------+          +--------------+
     | Interpreter |        |    JIT Compiler   |          | Garbage      |
     |             |        |-------------------|          | Collector    |
     | Executes    |        | Hotspot Detection |          |              |
     | bytecode    |        | Code Optimization |          | Removes      |
     | line-by-line|        | Native Code Gen   |          | unused objs  |
     +-------------+        +-------------------+          +--------------+
                                       |
                                       v
                              Native Machine Code
                                       |
                                       v
                                Program Output
```

---

# Heap Memory (Detailed Interview Level)

Heap is the **main memory area where objects are stored**.

Heap is divided into **generations** to improve garbage collection efficiency.

### Heap Structure

```
Heap
 |
 |---- Young Generation
 |       |
 |       |---- Eden Space
 |       |
 |       |---- Survivor Space S0
 |       |
 |       |---- Survivor Space S1
 |
 |---- Old Generation (Tenured)
```

---

## 1 Young Generation

All **new objects are created here**.

Components:

### Eden Space

When an object is created:

```
Student s = new Student();
```

The object is first allocated in **Eden space**.

### Survivor Spaces

Two survivor spaces exist:

```
S0 (From Space)
S1 (To Space)
```

Objects that survive garbage collection move between these two spaces.

---

## 2 Old Generation (Tenured)

Objects that survive multiple GC cycles are moved to **Old Generation**.

Example:

```
Long living objects
Cache objects
Session objects
```

Garbage collection here is **slower but less frequent**.

---

# Metaspace (Java 8+)

Before Java 8:

```
Permanent Generation (PermGen)
```

After Java 8:

```
Metaspace
```

Metaspace stores:

```
Class metadata
Method metadata
Runtime constant pool
Static variables
Class structure
```

Important point:

Metaspace uses **native memory instead of JVM heap**.

---

# Thread Stack (Per Thread)

Every thread has its **own stack memory**.

Example:

```
Thread A → Stack A
Thread B → Stack B
```

Each stack contains **stack frames**.

Stack Frame contains:

```
Local Variables
Operand Stack
Method Reference
Return Address
```

Example Flow

```
main()
   |
   |---- calculate()
             |
             |---- print()
```

Each method call creates a **new stack frame**.

---

# JIT Compilation Pipeline (Important for Interviews)

JIT improves JVM performance.

Instead of interpreting every instruction repeatedly, JVM compiles **frequently executed code into native machine code**.

### JIT Pipeline

```
Bytecode
   |
   v
Interpreter executes initially
   |
   v
Hotspot Detection
   |
   v
JIT Compiler
   |
   v
Code Optimization
   |
   v
Native Machine Code
```

Hotspot means:

```
Frequently executed methods
Frequently executed loops
```

---

# Garbage Collection Types (Important Interview Topic)

Garbage Collector automatically removes **unused objects from heap memory**.

---

# Types of Garbage Collection

### 1 Minor GC

Occurs in:

```
Young Generation
```

Process:

```
Eden → Survivor Spaces
```

Fast operation.

---

### 2 Major GC

Occurs in:

```
Old Generation
```

Slower than Minor GC.

---

### 3 Full GC

Occurs when JVM cleans:

```
Young Generation
Old Generation
Metaspace
```

This is the **slowest GC process**.

---

# Popular Garbage Collectors

Interviewers may ask this.

### Serial GC

Single-threaded GC.

Used in small applications.

---

### Parallel GC

Uses multiple threads.

Better performance for large applications.

---

### CMS (Concurrent Mark Sweep)

Reduces pause time.

Runs concurrently with application threads.

---

### G1 GC (Garbage First)

Modern GC.

Divides heap into regions.

Goal:

```
Predictable pause times
Efficient memory usage
```

---

# JVM Execution Flow (Complete)

```
Step 1
Developer writes Java code
       |
       v
Step 2
javac compiles code
       |
       v
Step 3
Bytecode (.class) generated
       |
       v
Step 4
Class Loader loads classes
       |
       v
Step 5
Classes stored in Metaspace
       |
       v
Step 6
Objects created in Heap (Eden)
       |
       v
Step 7
Method execution in Thread Stack
       |
       v
Step 8
Execution Engine runs bytecode
       |
       v
Interpreter + JIT compilation
       |
       v
Machine Code executed by CPU
       |
       v
Garbage Collector removes unused objects
       |
       v
Program Output
```

---

# 10-Second Interview Answer

**JVM is a runtime environment that loads Java bytecode using the Class Loader, stores data in memory areas like Heap, Metaspace and Thread Stacks, executes code using the Execution Engine with Interpreter and JIT Compiler, and manages memory automatically using Garbage Collection.**





