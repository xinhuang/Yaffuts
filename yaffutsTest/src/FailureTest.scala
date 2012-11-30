import java.util.ArrayList
import yaffuts._

class FailureTest extends Test {

  override def testMethods: ArrayList[TestMethod] = {
    val result = new ArrayList[TestMethod]()
    result.add(new TestMethod("given_assert_failure_should_fail", given_assert_failure_should_fail))
    result
  }


  def given_assert_failure_should_fail() = {
    Assert.fail()
  }
}
