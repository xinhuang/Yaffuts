import yaffuts._

class AssertFailTestClass extends Test {
  override val testMethods: TestMethodCollection = new TestMethodCollection()

  val expectFailure = 1

  test {
    Assert.fail()
  }
}
