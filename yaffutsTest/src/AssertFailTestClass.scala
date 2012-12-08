import yaffuts._

class AssertFailTestClass extends Test {
  override val testMethods: TestMethods = {
    val result = new TestMethods()
    result.add("given_assert_failure_should_fail", given_assert_failure_should_fail _)
    result
  }

  def given_assert_failure_should_fail() = {
    Assert.fail()
  }
}
