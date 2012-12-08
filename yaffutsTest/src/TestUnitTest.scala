import yaffuts.{TestMethods, Test}

class TestUnitTest extends Test {

  override def testMethods: TestMethods = {
    val result = new TestMethods()
    result.add("given_assert_failure_should_fail", given_assert_fail_execute_should_fail_total_be_1 _)
    result
  }

  def given_assert_fail_execute_should_fail_total_be_1() {
    val sut = new FailureTest
    val expected = sut.failTotal + 1

    sut.run()

    Assert.areEqual(expected, sut.failTotal)
  }
}