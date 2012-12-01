package yaffuts

trait Assertions {
  object Assert {
    def fail() = { throw new AssertionException() }

    def areEqual[T](expect:T, actual:T) = {
      if (expect != actual) {
        throw new AssertionException()
      }
    }
  }
}
