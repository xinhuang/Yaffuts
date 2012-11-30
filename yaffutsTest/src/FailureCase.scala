import yaffuts._

class FailureTest extends Test {
  override def cases:Array[()=>Unit] = {
    val result = new Array[()=>Unit](1)
    result(0) = given_assert_failure_should_fail _
    return result
  }

  def given_assert_failure_should_fail() = {
    Assert.fail()
  }
}
