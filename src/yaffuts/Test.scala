package yaffuts

class Test extends Assertions {
  var onFail:String=>Unit = null

  def cases:Array[()=>Unit] = null

  def run() {
    for (i <- 0 until cases.length) {
      cases(i)()
    }
  }
}

object Test {
  import java.util.ArrayList
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
