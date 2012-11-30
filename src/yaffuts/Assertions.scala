package yaffuts

trait Assertions {
  def onFail:String=>Unit
  def currentMethod:TestMethod

  object Assert {
    def fail() = onFail(currentMethod.name)
  }
}
