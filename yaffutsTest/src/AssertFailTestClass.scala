import yaffuts._

class AssertFailTestClass extends Test {
  override val testMethods: TestMethodCollection = {
    val result = new TestMethodCollection()
//    result.add("given_assert_failure_should_fail", given_assert_failure_should_fail _)
    result
  }

  val expectFailure = 1

  test {
    Assert.fail()
  }
}
