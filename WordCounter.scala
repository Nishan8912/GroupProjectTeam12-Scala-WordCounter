import scala.concurrent._ // Import for asynchronous programming
import scala.concurrent.duration._ // Import for handling time durations
import ExecutionContext.Implicits.global // Import for global execution context
import scala.io.{Source, StdIn} // Import for reading input and files

// Main object containing the word counter functionality
object WordCounter {
  def main(args: Array[String]): Unit = {
    // Display program options to the user
    println("Real-Time and File-Based Word Counter in Scala")
    println("Choose an option:")
    println("1. Real-time word count (interactive)")
    println("2. Upload and process a .txt file")
    print("Enter choice (1 or 2): ")

    // Read user input and call the appropriate function
    StdIn.readLine() match {
      case "1" => runRealTime() // Interactive mode
      case "2" => runFileBased() // File-based mode
      case _   => println("Invalid choice. Exiting.") // Handle invalid input
    }
  }

  // Asynchronous function to process text and count word frequencies
  def processTextAsync(text: String): Future[Map[String, Int]] = Future {
    // Split text into words, normalize to lowercase, and count occurrences
    val words = text
      .toLowerCase // Convert text to lowercase
      .split("\\W+") // Split by non-word characters
      .filter(_.nonEmpty) // Remove empty strings
      .groupBy(identity) // Group words by their value
      .view
      .mapValues(_.length) // Count occurrences of each word
      .toMap // Convert to a map

    // Print the word count result
    println(s"Word Count: $words")
    words
  }

  // Function to handle real-time word counting (interactive mode)
  def runRealTime(): Unit = {
    println("Type lines of text (type 'exit' to quit):")
    def loop(): Unit = {
      val input = StdIn.readLine("> ") // Read user input
      if (input != "exit") { // Check if the user wants to exit
        processTextAsync(input) // Process the input asynchronously
        loop() // Continue the loop
      } else {
        println("Exiting...") // Exit message
      }
    }
    loop() // Start the loop
  }

  // Function to handle file-based word counting
  def runFileBased(): Unit = {
    print("Enter path to .txt file: ")
    val filePath = StdIn.readLine() // Read the file path from the user
    try {
      // Read the file content and process it
      val fileContent = Source.fromFile(filePath).getLines().mkString(" ") // Read all lines and combine into a single string
      val futureResult = processTextAsync(fileContent) // Process the file content asynchronously
      Await.ready(futureResult, 10.seconds) // Wait for the result (with a timeout)
    } catch {
      case e: Exception =>
        // Handle file reading errors
        println(s"Error reading file: ${e.getMessage}")
    }
  }
}