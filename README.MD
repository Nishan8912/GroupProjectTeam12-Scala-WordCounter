# Scala Word Counter – Team 12

A dual-mode word counting application written in **Scala**, supporting both:

- Real-time terminal input (interactive)
- File-based `.txt` input (batch mode)

This project was developed for the CS 471 Programming Languages Group Project – Phase 2 to demonstrate Scala’s strengths: **pattern matching**, **immutability**, **concurrency with Futures**, and the **collections API**.

---

## Features

- **Asynchronous processing** using Scala `Future`
- **Pattern matching** and functional pipelines with Scala collections
- **Immutability-first** design
- **Interactive CLI** with user-friendly prompts

---

##  How to Run in GitHub Codespaces

### 1. Open a GitHub Codespace

1. Go to this repository
2. Click the green `Code` button → `Codespaces` tab
3. Create a new codespace

### 2. Install Java & Scala CLI (First Time Only)

In the terminal:

```bash
sudo apt update
sudo apt install openjdk-17-jdk -y

curl -fLo scala-cli.gz https://github.com/VirtusLab/scala-cli/releases/latest/download/scala-cli-x86_64-pc-linux.gz
gzip -d scala-cli.gz
chmod +x scala-cli
sudo mv scala-cli /usr/local/bin/

scala-cli version  # should show a version
