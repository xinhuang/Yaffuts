package yaffuts

import java.util

class Test extends Assertions {
  var onFail:String=>Unit = null

  def cases:Array[()=>Unit] = null

  def run() = {
    for (i <- 0 until cases.length) {
      cases(i)()
    }
  }
}

object Test {
  private val tests = new util.ArrayList[Test]

  def register(test:Test) = {
    tests.add(test)
  }

  def run() = {
    for (i <- 0 until tests.size) {
      tests.get(i).run
    }
  }
}