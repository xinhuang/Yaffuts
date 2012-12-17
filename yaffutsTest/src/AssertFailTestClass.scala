import yaffuts._

class AssertFailTestClass extends Test {
  val expectFailure = 1

  test ("given assert fail should fail") {
    Assert.fail()
  }
}
