import yaffuts.{AssertionException, TestMethodCollection, Test}

class AssertionUnitTest extends Test {
  override val testMethods: TestMethodCollection = new TestMethodCollection(
    ("given_assert_failure_should_assertion_exception_contains_assert_failure_message",
      given_assert_failure_should_assertion_exception_contains_assert_failure_message),
      ("given_assert_is_true_failed_should_assertion_exception_contains_specified_message",
        given_assert_is_true_failed_should_assertion_exception_contains_specified_message)
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

  def given_assert_is_true_failed_should_assertion_exception_contains_specified_message() {
    try {
      Assert.isTrue(false)
    }
    catch {
      case e: AssertionException =>
        Assert.isTrue(e.getMessage.toLowerCase.contains("expect true"))
    }
  }
}
