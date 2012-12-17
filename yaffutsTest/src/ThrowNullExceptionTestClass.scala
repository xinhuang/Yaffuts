import yaffuts.Test

class ThrowNullExceptionTestClass extends Test {
  val expectFailure = 1

  test("given access a null reference should throw exception") {
    val someVar: String = null

    someVar.contains("don't care")
  }
}
