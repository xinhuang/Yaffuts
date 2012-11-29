class FailureTest {
  var onFail:String=>Unit = null
  def run = {
    onFail("given_failure_assertion_should_test_fail")
  }
}
