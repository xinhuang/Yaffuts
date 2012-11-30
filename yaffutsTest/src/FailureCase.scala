import yaffuts._
import java.util.ArrayList

class FailureTest extends Test {
  override def cases:ArrayList[()=>Unit] = {
    val result = new ArrayList[()=>Unit]
    result.add(given_assert_failure_should_fail _)
    return result
  }

  def given_assert_failure_should_fail() = {
    Assert.fail()
  }
}
