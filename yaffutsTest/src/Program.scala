import yaffuts._

object Program {
  def main(argv:Array[String]) = {
    val sut = new FailureTest

    var failureName:String = null
    sut.onFail = (caseName:String) => failureName = caseName
    sut.run

    if (failureName == "given_assert_failure_should_fail")
      println("Succeed")
    else
      println("Failed")
  }
}
