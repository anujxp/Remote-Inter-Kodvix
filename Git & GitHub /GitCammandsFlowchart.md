# 1️⃣ Git Commands Flowchart (Easy to Remember)

This flowchart shows the **complete Git workflow developers follow daily**.

```
        Start Project
             │
             ▼
        Write Code
             │
             ▼
        git status
   (check modified files)
             │
             ▼
          git add
   (move files to staging)
             │
             ▼
       git commit -m
   (save snapshot locally)
             │
             ▼
          git push
   (upload code to GitHub)
             │
             ▼
        Team Members
          git pull
   (download latest code)
```

### Simple Explanation

**Step 1 — Write Code**

You create or modify files.

Example:

```
index.html
style.css
app.js
```

---

**Step 2 — Check Changes**

```
git status
```

This command tells you:

* which files changed
* which files are staged
* which files are untracked

---

**Step 3 — Add Files**

```
git add .
```

This moves the files to the **staging area**.

Think of staging as:

> preparing files before saving a version.

---

**Step 4 — Commit Changes**

```
git commit -m "Added login page"
```

This creates a **snapshot of your project**.

Git now records:

* author
* timestamp
* message
* commit ID

---

**Step 5 — Push to GitHub**

```
git push origin main
```

This uploads the code to **GitHub repository**.

Now other developers can see your changes.

---

# 2️⃣ Git Branching Diagram (Used in Companies)

Branching allows multiple developers to work on different features **without breaking the main project**.

### Basic Branching Structure

```
                main
                 │
       ┌─────────┼─────────┐
       │         │         │
       ▼         ▼         ▼
 login-feature payment-feature dashboard-feature
```

Each branch represents **a separate feature**.

Developers work independently on their branches.

---

## Example Development Flow

```
main
 │
 │
 ├── login-feature
 │       │
 │       └── commit changes
 │
 ├── payment-feature
 │       │
 │       └── commit changes
 │
 └── dashboard-feature
         │
         └── commit changes
```

After the feature is completed, it is merged into **main**.

---

## Merge Process

```
login-feature
      │
      ▼
 Pull Request
      │
      ▼
 Code Review
      │
      ▼
 Merge into main
```

This ensures:

✔ code quality
✔ bug checking
✔ team collaboration

---

# 3️⃣ Real Project Example (How Teams Use Git Daily)

Let's imagine a **real company project**.

Project: **E-commerce Website**

Team members:

| Developer | Task              |
| --------- | ----------------- |
| Dev 1     | Login system      |
| Dev 2     | Payment system    |
| Dev 3     | Product dashboard |

---

## Step 1 — Clone Repository

Every developer downloads the project.

```
git clone https://github.com/company/ecommerce-project.git
```

Project structure:

```
ecommerce-project
 ├── frontend
 ├── backend
 └── database
```

---

## Step 2 — Create Feature Branch

Developer working on login creates a branch.

```
git checkout -b login-feature
```

Now the structure looks like:

```
main
  │
  └── login-feature
```

---

## Step 3 — Write Code

Developer writes login code.

Example:

```
login.js
loginController.java
loginAPI.php
```

---

## Step 4 — Add and Commit

```
git add .
git commit -m "Created login functionality"
```

---

## Step 5 — Push Branch

```
git push origin login-feature
```

The branch now exists on GitHub.

---

## Step 6 — Create Pull Request

Developer creates a **Pull Request (PR)**.

Workflow:

```
login-feature
      │
      ▼
Pull Request
      │
      ▼
Team Review
```

---

## Step 7 — Code Review

Senior developers check:

✔ code quality
✔ bugs
✔ performance
✔ security

---

## Step 8 — Merge into Main

After approval:

```
login-feature → main
```

Final project structure:

```
main
 ├── login system
 ├── payment system
 └── dashboard
```

---

# 4️⃣ Professional Git Workflow Used in Companies

Most companies follow this workflow:

```
Clone Repository
       │
Create Feature Branch
       │
Write Code
       │
git add
       │
git commit
       │
git push
       │
Create Pull Request
       │
Code Review
       │
Merge to main
```

This process ensures:

✔ organized development
✔ clean code history
✔ safe collaboration

---

# ⭐ Pro Tip (Important for Internship)

Always follow this order:

```
git pull
git add .
git commit -m "message"
git push
```

Why?

Because **pulling first prevents conflicts**.

---

# 🎯 Final Understanding

After learning Git & GitHub you should understand:

✔ Version control
✔ Code history tracking
✔ Collaboration workflow
✔ Branching system
✔ Pull requests

These concepts are **used in almost every software company**.

