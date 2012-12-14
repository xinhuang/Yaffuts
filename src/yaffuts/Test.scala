package yaffuts

import yaffuts.ArrayListEx._
import java.util

abstract class Test extends Assertions {
  protected var onProgress:()=>Unit = () => {}

  private var currentMethod:TestMethod = null

  protected val testMethods:TestMethodCollection

  var failTotal:Int = 0
  var succTotal:Int = 0

  def printFailureMessage() {
    testMethods.select(o => !o.isSuccessful).each(o => o.printErrorMessage)
  }

  def run() {
    for (i <- 0 until testMethods.size) {
      currentMethod = testMethods(i)
      try {
        currentMethod.method()
      } catch {
        case e:AssertionException => onAssertionFail(e)
        case e => onUnexpectException(e)
      }
      if (currentMethod.isSuccessful) {
        succTotal += 1
      }else{
        failTotal += 1
      }
      onProgress()
    }
  }

  private def onUnexpectException(e: Throwable) {
    currentMethod.errorMessage = "Unexpected exception <" + e.toString + "> caught:"
    onFail(e.getStackTrace)
  }

  private def onAssertionFail(e:AssertionException) {
    currentMethod.errorMessage = e.getMessage
    onFail(e.getStackTrace)
  }

  private def onFail(stackTrace: Array[StackTraceElement]) {
    currentMethod.isSuccessful = false
    currentMethod.stackTrace = stackTrace.drop(1)
  }
}

object Test {
  private val tests = new util.ArrayList[Test]

  def register(test:Test) = {
    test.onProgress = () => { print(".") }
    tests.add(test)
  }

  def run() {
    val (succTotal, failTotal) = runAllTests()
    println()
    printFailureMessage()
    printf("Test: %d. Succeed: %d. Fail: %d.\n",
      succTotal + failTotal, succTotal, failTotal)
  }

  private def runAllTests():(Int, Int) = {
    var succTotal = 0
    var failTotal = 0
    for (i <- 0 until tests.size) {
      tests(i).run()
      succTotal += tests(i).succTotal
      failTotal += tests(i).failTotal
    }
    (succTotal, failTotal)
  }

  private def printFailureMessage() {
    tests.each(o => o.printFailureMessage())
  }
}
