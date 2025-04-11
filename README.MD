# Scala Word Counter – Team 12

A dual-mode word counter written in **Scala**, supporting:

-  **Interactive Mode**: Users enter lines in real-time
-  **File Mode**: Process a full `.txt` file for word frequencies

This project demonstrates Scala’s strengths in **functional programming**, **concurrency**, and **collections** — developed for CS 471 Group Project: Phase 2.

---

## Features

- Asynchronous processing with `Future`
- Immutable, functional data transformations
- Real-time or batch (file-based) word counting
- Works in **GitHub Codespaces** & **VS Code (local)**

---

## Project Files

. ├── WordCounter.scala # Main program ├── README.md # Documentation ├── scala_wikipedia.txt


---

## How to Run

You can run this project in two ways:

### Option 1: Run in **GitHub Codespaces**

#### First-time setup (in terminal):
```bash
sudo apt update
sudo apt install openjdk-17-jdk -y

curl -fLo scala-cli.gz https://github.com/VirtusLab/scala-cli/releases/latest/download/scala-cli-x86_64-pc-linux.gz
gzip -d scala-cli.gz
chmod +x scala-cli
sudo mv scala-cli /usr/local/bin/

##### Then run the app:
```bash
scala-cli run WordCounter.scala

### Option 2: Run Locally in Visual Studio Code
1.Install prerequisites:
Java JDK 17+ → https://adoptium.net

Scala CLI → https://scala-cli.virtuslab.org/install

VS Code Extensions:

Metals (Scala language support)

2. Run in terminal:
scala-cli run WordCounter.scala

### Using the Program
When running, you'll see:

Real-Time and File-Based Word Counter in Scala
Choose an option:
1. Real-time word count (interactive)
2. Upload and process a .txt file
Mode 1: Interactive Input
Enter lines manually (one at a time)

Type exit to quit

Mode 2: File Input
Enter the name of a .txt file in the project directory, e.g.:
scala_wikipedia.txt