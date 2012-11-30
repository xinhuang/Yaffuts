package yaffuts

import java.util.ArrayList

abstract class Test extends Assertions {
  var onFail:String=>Unit = null

  def cases:ArrayList[()=>Unit]

  def run() {
    for (i <- 0 until cases.size) {
      cases.get(i)()
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
      tests.get(i).run()
    }
  }
}
