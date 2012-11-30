package yaffuts

class Test extends Assertions {
  var onFail:String=>Unit = null

  def tests:Array[()=>Unit] = null

  def run() = {
    for (i <- 0 until tests.length) {
      tests(i)()
    }
  }
}
