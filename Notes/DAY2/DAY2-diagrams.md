# 🧠 JVM Memory Deep Dive

### Heap Structure • G1 GC • Memory Leak vs OutOfMemoryError

<p align="center">

<img src="https://img.shields.io/badge/Java-JVM-blue?style=for-the-badge&logo=java"/>
<img src="https://img.shields.io/badge/Topic-Memory%20Management-orange?style=for-the-badge"/>
<img src="https://img.shields.io/badge/Level-Interview%20Preparation-green?style=for-the-badge"/>
<img src="https://img.shields.io/badge/GC-Garbage%20Collector-red?style=for-the-badge"/>

</p>

---

# 📦 1️⃣ JVM Heap Structure

## 📖 What is Heap Memory?

> 🟦 **Heap Memory** is the runtime memory area in JVM where **objects and instance variables are stored.**

Whenever an object is created using the `new` keyword, memory is allocated in the **Heap**.

### Example

```java
Student s = new Student();
```

📌 Here the **Student object** is stored in **Heap Memory**.

💡 Heap memory is managed by the **Garbage Collector (GC)**.

---

# 🏗 Heap Memory Structure

Modern JVM divides heap into **three main parts**:

```
1️⃣ Young Generation
2️⃣ Old Generation
3️⃣ Metaspace
```

---

## 📊 Heap Structure Overview

<p align="center">

<img src="https://miro.medium.com/1%2Aiu2q9yLXLqIQ7skX8uhFkw.png" width="500">

</p>

---

# 🌱 1️⃣ Young Generation

Young Generation stores **newly created objects**.

📌 Most Java objects are **short-lived**, so they are first placed here.

### Structure of Young Generation

```
Young Generation
   │
   ├── Eden Space
   ├── Survivor Space S0
   └── Survivor Space S1
```

---

## 🔄 Object Allocation Flow

### Step 1 — Object Creation

```
New Object → Eden Space
```

---

### Step 2 — Minor Garbage Collection

If object survives GC:

```
Eden → Survivor Space (S0 or S1)
```

---

### Step 3 — Promotion

After surviving multiple GC cycles:

```
Survivor → Old Generation
```

---

# 🧓 2️⃣ Old Generation (Tenured Generation)

Old Generation stores **long-lived objects**.

These objects have **survived multiple Minor GC cycles**.

### Examples

✔ Application caches
✔ Objects used throughout the application
✔ Long-running services

---

### Garbage Collection Here

GC in this region is called:

```
Major GC
or
Full GC
```

⚠ This GC is **slow and expensive** because it scans large memory areas.

---

# 🧾 3️⃣ Metaspace

Metaspace stores **class metadata**.

### It contains:

✔ Class structure
✔ Method information
✔ Static variables
✔ Runtime constant pool

---

### Important JVM Change

| Java Version     | Memory Area |
| ---------------- | ----------- |
| Java 7 and below | PermGen     |
| Java 8 and above | Metaspace   |

---

### Advantage

Metaspace is stored in **Native Memory** instead of heap.

Benefits:

✔ Dynamic memory allocation
✔ No fixed size limitation
✔ Better memory management

---

# 🔁 Complete Object Lifecycle

```
Object Created
      │
      ▼
   Eden Space
      │
      ▼
   Minor GC
      │
      ▼
   Survivor Space
      │
      ▼
Multiple GC Cycles
      │
      ▼
Old Generation
      │
      ▼
Major GC
      │
      ▼
Object Removed
```

---

# 🎤 Interview Answer — JVM Heap Structure

💬 **Question**

Explain JVM Heap Structure.

✅ **Answer**

> JVM heap memory is divided into three main regions: Young Generation, Old Generation, and Metaspace. Newly created objects are first allocated in the Eden space inside the Young Generation. If objects survive garbage collection cycles, they move to Survivor spaces and eventually to the Old Generation where long-lived objects are stored. Metaspace stores class metadata and replaced PermGen starting from Java 8.

---

# ♻️ 2️⃣ G1 Garbage Collector

## What is Garbage Collection?

> Garbage Collection is the **automatic process of removing unused objects from memory.**

Java provides multiple GC algorithms:

```
Serial GC
Parallel GC
CMS GC
G1 GC
```

---

# 🚀 What is G1 GC?

> **G1 (Garbage First) GC** is a modern garbage collector designed for **large heap sizes and low pause times.**

📌 Introduced in **Java 7**
📌 Default GC from **Java 9**

---

# ⚠ Problem with Traditional GC

Traditional GC divides heap into:

```
Young Generation
Old Generation
```

During GC it scans **large memory areas**, causing **long pause times**.

---

# 🧩 G1 GC Solution

G1 divides heap into **many small regions instead of large generations.**

Example:

```
Region 1
Region 2
Region 3
Region 4
Region 5
```

Each region can behave like:

```
Eden
Survivor
Old
```

---

## 📊 G1 Heap Structure

<p align="center">

<img src="https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/G1GettingStarted/images/HeapStructure.png" width="550">

</p>

---

# ⚙️ How G1 GC Works

### Step 1 — Object Allocation

Objects are created in **Eden regions**.

---

### Step 2 — Garbage Identification

G1 identifies regions with:

```
Most Garbage
```

---

### Step 3 — Garbage Collection

GC cleans **those regions first**.

This is why it is called:

```
Garbage First Collector
```

---

### Step 4 — Memory Compaction

G1 performs **memory compaction** to remove fragmentation.

Meaning:

```
Objects are rearranged to free contiguous memory
```

---

# ✅ Advantages of G1 GC

✔ Predictable pause time
✔ Efficient for large heap applications
✔ Region-based cleaning
✔ Reduced fragmentation

---

# 🎤 Interview Answer — G1 GC

💬 **Question**

Explain G1 Garbage Collector.

✅ **Answer**

> G1 Garbage Collector divides heap memory into multiple regions instead of fixed generations. It prioritizes regions with the most garbage and cleans them first, which reduces pause times and improves performance for large heap applications.

---

# 🚨 3️⃣ Memory Leak vs OutOfMemoryError

This is a **very common interview question**.

---

# 🧯 Memory Leak

> A **memory leak occurs when objects are no longer needed but are still referenced**, preventing garbage collection.

### Example

```java
List<Object> list = new ArrayList<>();

while(true){
    list.add(new Object());
}
```

Objects remain referenced in the list.

Result:

```
Memory usage keeps increasing
```

---

# 💥 OutOfMemoryError

OutOfMemoryError occurs when:

```
JVM cannot allocate more memory
```

Example error:

```
java.lang.OutOfMemoryError: Java heap space
```

---

# 📊 Difference Between Memory Leak and OOM

| Feature     | Memory Leak                     | OutOfMemoryError           |
| ----------- | ------------------------------- | -------------------------- |
| Meaning     | Unused objects still referenced | JVM cannot allocate memory |
| Cause       | Bad coding practice             | Memory exhaustion          |
| GC behavior | GC cannot remove objects        | GC tries but fails         |
| Result      | Gradual memory growth           | Application crash          |

---

# 🎤 Interview Answer

💬 **Difference between Memory Leak and OutOfMemoryError**

> A memory leak occurs when unused objects remain referenced and cannot be garbage collected. Over time this consumes memory and may eventually lead to an OutOfMemoryError, which occurs when the JVM cannot allocate additional memory.

---

# 🧠 Scenario-Based Interview Questions

---

## Scenario 1

### Question

Application memory keeps increasing but GC runs normally.

### Answer

> This usually indicates a **memory leak**, where objects are still referenced and cannot be garbage collected.

---

## Scenario 2

### Question

Application crashes with:

```
OutOfMemoryError: Java heap space
```

### Steps to Debug

1️⃣ Check heap size

2️⃣ Generate heap dump

3️⃣ Use profiling tools:

```
VisualVM
JProfiler
Eclipse MAT
```

4️⃣ Identify objects consuming excessive memory

---

## Scenario 3

### Question

Why is G1 GC preferred for large applications?

### Answer

> G1 GC divides heap into multiple regions and collects garbage from the most garbage-heavy regions first, helping maintain predictable pause times and improving performance.

---

# ⚡ One-Line Interview Summary

### JVM Heap Structure

> JVM heap is divided into Young Generation, Old Generation, and Metaspace where objects are allocated and managed by garbage collection.

---

### G1 Garbage Collector

> G1 GC divides heap into regions and cleans regions with the most garbage first to reduce pause time.

---

### Memory Leak

> Memory leak occurs when unused objects remain referenced and cannot be garbage collected.

---

### OutOfMemoryError

> OutOfMemoryError occurs when JVM cannot allocate additional memory.

---

⭐ If you want, I can also show you how to add **these insane GitHub README features**:

* 🐍 Contribution Snake Animation
* 🏆 GitHub Trophy Section
* 📊 Auto GitHub Stats
* 🔥 Animated JVM Diagram
* 🎯 Expand/Collapse Interview Sections

That will make your **internship repo look like a senior developer project.** 🚀


```mermaid
flowchart TD

A[New Object] --> B[Eden Region]

B --> C{Minor GC}

C -->|Alive| D[Survivor Region]
C -->|Dead| E[Collected]

D --> F{Survive Many GC Cycles}

F -->|Yes| G[Old Region]
F -->|No| H[Back to Survivor]

G --> I{Old Region GC}

I --> J[Garbage First Selection]

J --> K[Cleanup Regions]

K --> L[Compaction]

L --> M[Free Memory]

style B fill:#90caf9
style D fill:#ffe082
style G fill:#ef9a9a
style K fill:#a5d6a7
```


## ♻️ G1 Garbage Collector Region Workflow

```mermaid
flowchart LR

subgraph Young_Generation
A[Eden Region]
B[Survivor S0]
C[Survivor S1]
end

subgraph Old_Generation
D[Old Region 1]
E[Old Region 2]
F[Old Region 3]
end

A -->|Minor GC| B
A -->|Minor GC| C

B -->|Survive GC| C
C -->|Survive GC| B

B -->|Promotion Threshold Reached| D
C -->|Promotion Threshold Reached| D

D -->|Mixed GC| E
E -->|Mixed GC| F

F -->|Garbage First Cleanup| G[Memory Reclaimed]

G --> H[Heap Compaction]

H --> I[Free Regions Available]

style A fill:#90caf9
style B fill:#ffe082
style C fill:#ffe082
style D fill:#ef9a9a
style E fill:#ef9a9a
style F fill:#ef9a9a
style G fill:#a5d6a7
style H fill:#ce93d8
style I fill:#80cbc4
```
