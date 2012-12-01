package yaffuts

import java.util.ArrayList
import yaffuts.ArrayListEx._

abstract class Test extends Assertions {
  protected def onFail(e:AssertionException) = {
    currentMethod.isSuccessfull = false
    currentMethod.errorMessage = e.getStackTrace().toString()
  }

  var currentMethod:TestMethod = null

  def testMethods:TestMethods

  var failTotal:Int = 0
  var succTotal:Int = 0

  def run() {
    for (i <- 0 until testMethods.size) {
      currentMethod = testMethods(i)
      try {
        currentMethod.method()
      } catch {
        case e:AssertionException => onFail(e)
      }
      if (currentMethod.isSuccessfull) {
        succTotal += 1
      }else{
        failTotal += 1
      }
      print(".")
    }
  }
}

object Test {
  private val tests = new ArrayList[Test]

  def register(test:Test) = {
    tests.add(test)
  }

  def run() {
    val (succTotal, failTotal) = runAllTests()
    printFailureMessage()
    printf("\nTest: %d. Succeed: %d. Fail: %d.\n",
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

  private def printFailureMessage() = {
  }
}
