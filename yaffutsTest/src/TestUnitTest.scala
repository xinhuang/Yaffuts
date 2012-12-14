import yaffuts.{TestMethodCollection, Test}

class TestUnitTest extends Test {

  override val testMethods: TestMethodCollection = new TestMethodCollection(
    ("given_assert_fail_execute_should_fail_total_increase", given_assert_fail_execute_should_fail_total_increase _),
    ("given_throw_null_exception_should_fail_total_increase", given_throw_null_exception_should_fail_total_increase _)
  )


  def given_assert_fail_execute_should_fail_total_increase() {
    val sut = new AssertFailTestClass

    sut.run()

    Assert.areEqual(sut.expectFailure, sut.failTotal)
  }

  def given_throw_null_exception_should_fail_total_increase() {
    val sut = new ThrowNullExceptionTestClass

    sut.run()

    Assert.areEqual(sut.expectFailure, sut.failTotal)
  }
}