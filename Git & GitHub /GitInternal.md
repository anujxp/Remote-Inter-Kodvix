
# 1️⃣ Git Internals (How Git Actually Stores Data)

Many people think Git stores **changes**, but actually Git stores **snapshots of the entire project**.

### How Git Works Internally

Whenever you run:

```bash
git commit -m "Added login feature"
```

Git performs these actions:

1️⃣ Takes a **snapshot of all tracked files**
2️⃣ Saves it in the **.git directory**
3️⃣ Assigns a **unique commit ID (SHA hash)**
4️⃣ Links the commit with the previous commit

### Commit Structure

```
Commit
 ├── Commit ID (SHA-1 hash)
 ├── Author
 ├── Timestamp
 ├── Commit Message
 └── Snapshot of Files
```

Example commit log:

```
a7d93f  Added login feature
b72fa3  Initial project setup
```

Each commit is connected like a **chain**.

```
Commit 1 → Commit 2 → Commit 3 → Commit 4
```

This is why Git history is very reliable.

---

# 2️⃣ Merge Conflicts (Important Concept)

A **merge conflict** happens when **two developers modify the same part of a file**.

### Example Situation

Developer A edits:

```
login.js
```

Developer B also edits:

```
login.js
```

Both push changes.

When merging, Git cannot decide which code to keep.

---

### Conflict Example

```
<<<<<<< HEAD
console.log("Login Successful");
=======
console.log("User Logged In");
>>>>>>> login-feature
```

Meaning:

* `HEAD` → code from main branch
* `login-feature` → code from feature branch

---

### How to Resolve Conflict

1️⃣ Open the file
2️⃣ Choose correct code
3️⃣ Remove conflict markers

Example fixed version:

```
console.log("User Login Successful");
```

Then commit again.

```
git add .
git commit -m "Resolved merge conflict"
```

---

# 3️⃣ Git vs GitHub vs GitLab vs Bitbucket

Many beginners confuse these tools.

| Tool      | Type                 | Description                         |
| --------- | -------------------- | ----------------------------------- |
| Git       | Version Control Tool | Tracks code changes locally         |
| GitHub    | Hosting Platform     | Cloud platform for Git repositories |
| GitLab    | DevOps Platform      | Git hosting + CI/CD                 |
| Bitbucket | Git Hosting          | Used mainly with Atlassian tools    |

### Popularity

Most companies use:

🥇 GitHub
🥈 GitLab
🥉 Bitbucket

---

# 4️⃣ Most Asked Git Interview Questions

These are **very common interview questions**.

---

### What is Git?

Git is a **distributed version control system** used to track changes in source code and collaborate with developers.

---

### What is the difference between Git and GitHub?

| Git                  | GitHub                      |
| -------------------- | --------------------------- |
| Version control tool | Repository hosting platform |
| Works locally        | Works on cloud              |
| Tracks code history  | Enables collaboration       |

---

### What is a commit?

A **commit** is a snapshot of the project saved in the repository.

---

### What is a branch?

A branch is an independent line of development that allows developers to work on features without affecting the main project.

---

### What is a pull request?

A **Pull Request (PR)** is a request to merge changes from one branch into another after code review.

---

### What is git clone?

`git clone` downloads a repository from GitHub to your local computer.

Example:

```
git clone https://github.com/user/project.git
```

---

### What is git pull?

`git pull` downloads the latest updates from the remote repository and merges them into your local branch.

---

### What is git push?

`git push` uploads local commits to the remote repository.

---

# ⭐ Bonus: Important Git Commands Developers Use

These commands are extremely useful.

### See difference between files

```
git diff
```

---

### See branch history graph

```
git log --graph
```

---

### Delete branch

```
git branch -d branch-name
```

---

### Rename branch

```
git branch -m new-name
```

---

# 🎯 Final Summary

Git helps developers:

✔ track code history
✔ collaborate with teams
✔ manage versions
✔ experiment safely using branches

GitHub helps developers:

✔ host repositories
✔ manage projects
✔ review code through pull requests

Together, Git and GitHub are **the backbone of modern software development**.

---

# 🚀 Pro Tip for Your Internship README

Your README will look **10x more professional** if the sections are arranged like this:

```
1 Introduction to Git
2 Git vs GitHub
3 Git Architecture
4 Git Workflow
5 Git Commands
6 Git Branching
7 Git Collaboration Workflow
8 Pull Requests
9 Merge Conflicts
10 Git Internals
11 Git Tools Comparison
12 Interview Questions
```

---
