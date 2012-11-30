package yaffuts

trait Assertions {
  def onFail:String=>Unit


  object Assert {
    def fail() = {
      onFail("given_assert_failure_should_fail")
    }
  }
}
