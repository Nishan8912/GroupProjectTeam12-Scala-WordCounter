import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.io.{Source, StdIn}

object WordCounter {
  def main(args: Array[String]): Unit = {
    println("Real-Time and File-Based Word Counter in Scala")
    println("Choose an option:")
    println("1. Real-time word count (interactive)")
    println("2. Upload and process a .txt file")
    print("Enter choice (1 or 2): ")

    StdIn.readLine() match {
      case "1" => runRealTime()
      case "2" => runFileBased()
      case _   => println("Invalid choice. Exiting.")
    }
  }

  def processTextAsync(text: String): Future[Map[String, Int]] = Future {
    val words = text
      .toLowerCase
      .split("\\W+")
      .filter(_.nonEmpty)
      .groupBy(identity)
      .view
      .mapValues(_.length)
      .toMap

    println(s"Word Count: $words")
    words
  }

  def runRealTime(): Unit = {
    println("Type lines of text (type 'exit' to quit):")
    def loop(): Unit = {
      val input = StdIn.readLine("> ")
      if (input != "exit") {
        processTextAsync(input)
        loop()
      } else {
        println("Exiting...")
      }
    }
    loop()
  }

  def runFileBased(): Unit = {
    print("Enter path to .txt file: ")
    val filePath = StdIn.readLine()
    try {
      val fileContent = Source.fromFile(filePath).getLines().mkString(" ")
      val futureResult = processTextAsync(fileContent)
      Await.ready(futureResult, 10.seconds)
    } catch {
      case e: Exception =>
        println(s"Error reading file: ${e.getMessage}")
    }
  }
}
