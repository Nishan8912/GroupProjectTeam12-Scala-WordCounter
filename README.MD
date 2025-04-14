# Real-Time and File-Based Word Counter in Scala

This Scala program provides a simple and efficient way to count the occurrences of words in text. It offers two modes of operation: real-time interactive word counting and file-based word counting for `.txt` files.

---

## Features

### Real-Time Word Count (Interactive Mode):
- Allows users to input text line by line.
- Displays the word count for each line asynchronously.
- Users can exit the mode by typing `exit`.

### File-Based Word Count:
- Processes a `.txt` file provided by the user.
- Reads the file content, counts the occurrences of each word, and displays the result.
- Handles errors gracefully, such as invalid file paths or unreadable files.

---

## How It Works
- The program uses asynchronous processing (`Future`) to count words in the text.
- Words are normalized to lowercase, split by non-word characters, and grouped to calculate their frequency.
- Results are displayed as a map of words to their respective counts.


## Project Files
. ├── WordCounter.scala # Main program ├── README.md # Documentation ├── scala_wikipedia.txt


---

## How to Run

You can run this project in two ways:

### Option 1: Run in **GitHub Codespaces**

#### First-time setup (in terminal):
1. Update the package list and install Java JDK:
   ```bash
   sudo apt update
   sudo apt install openjdk-17-jdk -y
   ```

2. Install Scala CLI:
```bash
curl -fLo scala-cli.gz https://github.com/VirtusLab/scala-cli/releases/latest/download/scala-cli-x86_64-pc-linux.gz
gzip -d scala-cli.gz
chmod +x scala-cli
sudo mv scala-cli /usr/local/bin/
```

---


## Usage

1. Run the Program:
- Compile and run the program using Scala:
  ```bash
scala-cli run WordCounter.scala

2. Choose an Option:
Upon running, the program prompts you to choose between:
1: Real-time word count.
2: File-based word count.

3. Real-Time Word Count:
Type lines of text in the console.
The program will display the word count for each line.
Type exit to quit this mode.

4. File-Based Word Count:
Enter the path to a .txt file when prompted.
The program will read the file, count the words, and display the result.

Example Output
Real-Time Word Count

Real-Time and File-Based Word Counter in Scala
Choose an option:
1. Real-time word count (interactive)
2. Upload and process a .txt file
Enter choice (1 or 2): 1
Type lines of text (type 'exit' to quit):
> Hello world! Hello Scala.
Word Count: Map(hello -> 2, world -> 1, scala -> 1)
> exit
Exiting...

File-Based Word Count
Real-Time and File-Based Word Counter in Scala
Choose an option:
1. Real-time word count (interactive)
2. Upload and process a .txt file
Enter choice (1 or 2): 2
Enter path to .txt file: /path/to/sample.txt
Word Count: Map(scala -> 3, is -> 2, awesome -> 1)

Error Handling
If an invalid file path is provided, the program will display an error message:
Error reading file: /path/to/file (No such file or directory)

Dependencies
Scala standard library.
scala.concurrent for asynchronous processing.

Limitations
The program processes text in memory, which may not be suitable for very large files.
Word splitting is based on non-word characters (\\W+), which may not handle all edge cases (e.g., contractions or special characters

Future Improvements
Add support for processing large files in chunks.
Enhance word-splitting logic to handle more complex cases.
Provide an option to save the word count results to a file.
This program is a simple yet powerful tool for word counting, demonstrating the use of asynchronous programming in Scala.