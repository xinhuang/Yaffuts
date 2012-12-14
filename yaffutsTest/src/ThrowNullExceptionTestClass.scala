import yaffuts.{TestMethodCollection, Test}

class ThrowNullExceptionTestClass extends Test {
  override val testMethods: TestMethodCollection = new TestMethodCollection(
    ("given_access_a_null_reference_should_throw_exception", given_access_a_null_reference_should_throw_exception _)
  )

  val expectFailure = 1

  def given_access_a_null_reference_should_throw_exception() {
    val someVar: String = null

    someVar.contains("don't care")
  }
}
