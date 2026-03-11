# Visual Learning Diagrams – Java Concepts

                    +--------------------------+
                    |       Java Program       |
                    +------------+-------------+
                                 |
                                 v
                          +-------------+
                          |  Bytecode   |
                          +-------------+
                                 |
                                 v
                       +-------------------+
                       |   Class Loader    |
                       +---------+---------+
                                 |
                                 v
                       +-------------------+
                       |   Runtime Memory  |
                       +-------------------+

      +--------------------------------------------------------+
      |                        HEAP                            |
      |                                                        |
      |   Young Generation                                     |
      |   +------------------------------+                     |
      |   | Eden Space                   |                     |
      |   | Survivor S0                  |                     |
      |   | Survivor S1                  |                     |
      |   +------------------------------+                     |
      |                                                        |
      |   Old Generation (Tenured Objects)                     |
      |                                                        |
      +--------------------------------------------------------+

      +--------------------------------------------------------+
      |                TLAB (Thread Local Allocation Buffer)   |
      |                                                        |
      |  Thread 1 → TLAB                                       |
      |  Thread 2 → TLAB                                       |
      |  Thread 3 → TLAB                                       |
      |                                                        |
      |  Each thread allocates objects in its own buffer       |
      +--------------------------------------------------------+

      +--------------------------------------------------------+
      |                     METASPACE                          |
      |  Class Metadata                                        |
      |  Method Metadata                                       |
      |  Runtime Constant Pool                                 |
      +--------------------------------------------------------+

                                 |
                                 v

                     +---------------------------+
                     |     Execution Engine      |
                     +-------------+-------------+
                                   |
                 -----------------------------------------
                 |                                       |
                 v                                       v

        +---------------------+                +----------------------+
        |     Interpreter     |                |      JIT Compiler    |
        +---------------------+                +----------------------+
                                               |  C1 Compiler         |
                                               |  C2 Compiler         |
                                               +----------+-----------+
                                                          |
                                                          v
                                                Optimized Machine Code

                                 |
                                 v

                    +-----------------------------+
                    |       Garbage Collector     |
                    +-----------------------------+
                    |  GC Roots                   |
                    |  Safepoints                 |
                    +-----------------------------+




## 1. OOP Concepts Relationship Diagram

```
                    +------------------+
                    |      CLASS       |
                    +------------------+
                             |
                             |
                       Creates Objects
                             |
                             v
                     +---------------+
                     |     OBJECT     |
                     +---------------+

OOP PRINCIPLES
-------------------------------

1. Encapsulation
   Data + Methods inside class

2. Inheritance
   Child class acquires properties of Parent

3. Polymorphism
   Same method different behavior

4. Abstraction
   Hide implementation details
```

### Example Structure

```
        Animal (Parent Class)
               |
               |
        -----------------
        |               |
      Dog              Cat
   (Child Class)   (Child Class)
```

Use case:

```
Code Reusability
Better Software Design
Real world modelling
```

---

# 2. Object Memory Diagram (Heap & Stack)

When an object is created in Java:

```java
Student s = new Student();
```

Memory allocation happens like this:

```
        STACK MEMORY                    HEAP MEMORY

     +---------------+           +-------------------+
     |   Reference   | --------> |   Student Object  |
     |      s        |           |                   |
     +---------------+           | id                |
                                 | name              |
                                 +-------------------+
```

Explanation:

```
Stack → stores reference variables
Heap → stores actual objects
```

---

# 3. Shallow Copy vs Deep Copy Diagram

### Shallow Copy

```
Stack                        Heap

s1 --------|
           |------> Student Object
s2 --------|
```

Both references point to **same object**.

Problem:

```
Changing s1 will affect s2
```

---

### Deep Copy

```
Stack                        Heap

s1 --------> Object 1

s2 --------> Object 2
```

Each object has **separate memory**.

---

# 4. Static Keyword Concept Diagram

Static variables belong to **class not object**.

```
                CLASS AREA

            +------------------+
            |   Student Class  |
            |------------------|
            | static college   |
            +------------------+
                 /     |     \
                /      |      \
               v       v       v
            Object1  Object2  Object3
```

All objects share the **same static variable**.

Example:

```java
class Student {

 static String college = "GHSC";

}
```

---

# 5. Garbage Collection Diagram

Objects that are **not referenced anymore** become eligible for GC.

```
Before GC

Stack                Heap

s -----> Object A

t -----> Object B


After removing reference

Stack                Heap

s -----> Object A

t -----> null

Object B → Eligible for Garbage Collection
```

Then JVM removes unused object.

```
Garbage Collector cleans memory automatically
```

---

# 6. Heap Memory Generations (Important)

Heap is divided into **three main parts**.

```
               JVM HEAP MEMORY

        +-----------------------------+
        |      Young Generation       |
        |-----------------------------|
        | Eden Space                  |
        | Survivor Space S0           |
        | Survivor Space S1           |
        +-----------------------------+

        +-----------------------------+
        |     Old Generation          |
        |  Long living objects        |
        +-----------------------------+
```

Object Life Cycle

```
New Object → Eden
Survive GC → Survivor
Long life → Old Generation
```

---

# 7. Java Memory Model (JMM) Diagram

JMM defines **how threads interact with memory**.

```
                MAIN MEMORY
            (Shared Variables)

                |   |   |
        ----------------------------
        |            |            |
     Thread 1     Thread 2     Thread 3
        |            |            |
   Working       Working       Working
    Memory        Memory        Memory
```

Flow:

```
Main Memory → Thread Working Memory → Execution → Write Back
```

Important concepts:

```
Visibility
Atomicity
Ordering
```

---

# 8. Java Program Execution Flow

```
Step 1
Write Java Code
        |
        v
Step 2
Compile using javac
        |
        v
Bytecode (.class)
        |
        v
Class Loader loads class
        |
        v
Memory allocation (Heap + Stack)
        |
        v
Execution Engine
   |            |
Interpreter   JIT Compiler
        |
        v
Machine Code
        |
        v
Program Output
```

---

# Real Life Learning Summary

Today I learned the following Java concepts:

```
Java Basics
OOP Concepts
Object Copy (Shallow vs Deep)
Static Keyword
Garbage Collector
Java Memory Model
```

These concepts help in understanding:

```
How Java manages memory
How objects are created
How threads interact
How JVM optimizes performance
```

---

✅ **Tip for your Internship Repo**

Add a section like this in README:

```
Day 1 Learning
✔ Java Basics
✔ OOP Concepts
✔ Object Copy
✔ Static Keyword
✔ Garbage Collector
✔ Java Memory Model
```

---

If you want, I can also give you a **“Senior Developer Level Java Learning Map”** (roadmap of **what to study after these topics**) so your **internship learning becomes 10× stronger than other interns.**

