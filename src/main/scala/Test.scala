package yaffuts

import scala.collection.mutable

abstract class Test extends Assertions {
  private def onTestMethodFinished() = print(".")

  private var currentMethod: TestMethod = null

  var _failTotal: Int = 0
  def failTotal: Int = _failTotal
  var _succTotal: Int = 0
  def succTotal: Int = _succTotal

  def printFailureMessage() {
    testMethods.filter(o => !o.isSuccessful).foreach(o => o.printErrorMessage())
  }

  def run() {
    for (i <- 0 until testMethods.size) {
      currentMethod = testMethods(i)
      try {
        currentMethod.method()
      } catch {
        case e: AssertionException => onAssertionFail(e)
        case e: Throwable => onUnexpectException(e)
      }
      if (currentMethod.isSuccessful) {
        _succTotal += 1
      } else {
        _failTotal += 1
      }
      onTestMethodFinished()
    }
  }

  private val testMethods = new TestMethodCollection

  protected def test(name: String): (=> Unit) => Unit = {
    method => testMethods.add(name, method _)
  }

  private def onUnexpectException(e: Throwable) {
    currentMethod.errorMessage = "Unexpected exception <" + e.toString + "> caught:"
    onFail(e.getStackTrace)
  }

  private def onAssertionFail(e: AssertionException) {
    currentMethod.errorMessage = e.getMessage
    onFail(e.getStackTrace)
  }

  private def onFail(stackTrace: Array[StackTraceElement]) {
    currentMethod.isSuccessful = false
    currentMethod.stackTrace = stackTrace.drop(1)
  }
}

object Test {
  private val tests = new mutable.ArrayBuffer[Test]

  private def register(test: Test) = tests += test

  def register[T <: Test](testClass: Class[T]) {
    val testInstance: Test = testClass.newInstance()
    register(testInstance)
  }

  def run() {
    val (succTotal, failTotal) = runAllTests()
    println()
    printFailureMessage()
    printf("Test: %d. Succeed: %d. Fail: %d.\n",
      succTotal + failTotal, succTotal, failTotal)
  }

  private def runAllTests(): (Int, Int) = {
    var succTotal = 0
    var failTotal = 0
    tests.foreach ( test => {
      test.run()
      succTotal += test.succTotal
      failTotal += test.failTotal
    }
    )
    (succTotal, failTotal)
  }

  private def printFailureMessage() {
    tests.foreach(o => o.printFailureMessage())
  }
}
