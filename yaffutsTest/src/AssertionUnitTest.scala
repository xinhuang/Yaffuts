import yaffuts.{AssertionException, TestMethods, Test}

class AssertionUnitTest extends Test {
  override val testMethods: TestMethods = new TestMethods(
    ("given_assert_failure_should_assertion_exception_contains_assert_failure_message",
      given_assert_failure_should_assertion_exception_contains_assert_failure_message)
  )

  def given_assert_failure_should_assertion_exception_contains_assert_failure_message() {
    try {
      Assert.fail()
    }
    catch {
      case e: AssertionException =>
        Assert.isTrue(e.getMessage.toLowerCase.contains("failure"))
    }
  }
}
