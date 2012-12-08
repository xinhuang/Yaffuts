package yaffuts

import java.util.ArrayList
import yaffuts.ArrayListEx._

abstract class Test extends Assertions {
  def printFailureMessage() {
    testMethods.select(o => !o.isSuccessful).each(o => println(o.name))
  }

  var onProgress:()=>Unit = () => {}

  protected def onFail(e:Throwable) {
    currentMethod.isSuccessful = false
    currentMethod.errorMessage = e.getStackTrace.toString
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
        case e => onFail(e)
      }
      if (currentMethod.isSuccessful) {
        succTotal += 1
      }else{
        failTotal += 1
      }
      onProgress()
    }
  }
}

object Test {
  private val tests = new ArrayList[Test]

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
    tests.each(o => o.printFailureMessage)
  }
}
