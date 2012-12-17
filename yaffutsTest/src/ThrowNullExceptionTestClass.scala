import yaffuts.{TestMethodCollection, Test}

class ThrowNullExceptionTestClass extends Test {
  override val testMethods: TestMethodCollection = new TestMethodCollection

  val expectFailure = 1

  test("given access a null reference should throw exception") {
    val someVar: String = null

    someVar.contains("don't care")
  }
}
