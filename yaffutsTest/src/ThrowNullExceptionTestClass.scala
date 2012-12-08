import yaffuts.{TestMethods, Test}

class ThrowNullExceptionTestClass extends Test {
  def testMethods: TestMethods = new TestMethods(
    ("given_access_a_null_reference_should_throw_exception", given_access_a_null_reference_should_throw_exception _)
  )

  def given_access_a_null_reference_should_throw_exception() {
    val someVar: String = null

    someVar.contains("don't care")
  }
}
