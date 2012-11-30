package yaffuts

import java.util.ArrayList
import yaffuts.ArrayListEx._

abstract class Test extends Assertions {
  var onFail:String=>Unit = null
  var currentTestName:String = null
  var currentMethod:TestMethod = null

  def testMethods:TestMethods

  def run() {
    for (i <- 0 until testMethods.size) {
      currentTestName = testMethods(i).name
      currentMethod = testMethods(i)
      testMethods(i).method()
    }
  }
}

object Test {
  private val tests = new ArrayList[Test]

  def register(test:Test) = {
    tests.add(test)
  }

  def run() {
    for (i <- 0 until tests.size) {
      tests(i).run()
    }
  }
}
