object Program {
  def main(argv:Array[String]) = {
    val sut = new FailureTest

    var failureName:String = null
    sut.onFail = (caseName:String) => failureName = caseName
    sut.run

    if (failureName == "given_failure_assertion_should_test_fail")
      println("Succeed")
    else
      println("Failed")
  }
}
