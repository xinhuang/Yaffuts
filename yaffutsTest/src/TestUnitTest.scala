import yaffuts.{TestMethods, Test}

class TestUnitTest extends Test {

  override val testMethods: TestMethods = new TestMethods(
    ("given_assert_fail_execute_should_fail_total_increase", given_assert_fail_execute_should_fail_total_increase _),
    ("given_throw_null_exception_should_fail_total_increase", given_throw_null_exception_should_fail_total_increase _)
  )


  def given_assert_fail_execute_should_fail_total_increase() {
    val sut = new AssertFailTestClass
    val expect = sut.failTotal + 1

    sut.run()

    Assert.areEqual(expect, sut.failTotal)
  }

  def given_throw_null_exception_should_fail_total_increase() {
    val sut = new ThrowNullExceptionTestClass
    val expect = sut.failTotal + 1

    sut.run()

    Assert.areEqual(expect, sut.failTotal)
  }
}