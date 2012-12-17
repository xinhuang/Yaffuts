import yaffuts.{AssertionException, TestMethodCollection, Test}

class AssertionUnitTest extends Test {
  override val testMethods: TestMethodCollection = new TestMethodCollection

  test ("given Assert.failure should assertion exception contains assert failure message") {
    try {
      Assert.fail()
    }
    catch {
      case e: AssertionException =>
        Assert.isTrue(e.getMessage.toLowerCase.contains("failure"))
    }
  }

  test ("given Assert.isTrue failed should assertion exception contains specified message") {
    try {
      Assert.isTrue(false)
    }
    catch {
      case e: AssertionException =>
        Assert.isTrue(e.getMessage.toLowerCase.contains("expect true"))
    }
  }
}
