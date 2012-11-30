package yaffuts

trait Assertions {
  protected def onFail(errorMessage:String)
  protected def onSucceed():Unit

  object Assert {
    def fail() = {
      failed("Assert.fail()")
    }

    def areEqual[T](expect:T, actual:T) = {
      if (expect == actual) {
        succeeded()
      } else {
        failed("Assert.areEqual")
      }
    }

    private def succeeded():Unit = {
      onSucceed()
    }

    private def failed(errorMessage:String) = {
      onFail(errorMessage)
    }
  }
}
