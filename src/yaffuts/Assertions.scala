package yaffuts

trait Assertions {
  object Assert {
    def isTrue(expression: Boolean) {
      if (!expression)
        throw new AssertionException
    }

    def fail() = { throw new AssertionException("Assertion failure") }

    def areEqual[T](expect:T, actual:T) {
      if (expect != actual) {
        throw new AssertionException()
      }
    }
  }
}
