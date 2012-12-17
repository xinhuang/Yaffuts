import yaffuts.{TestMethodCollection, Test}

class TestUnitTest extends Test {
  test ("given assert fail execute should fail total increase") {
    val sut = new AssertFailTestClass

    sut.run()

    Assert.areEqual(sut.expectFailure, sut.failTotal)
  }

  test ("given throw null exception should fail total increase") {
    val sut = new ThrowNullExceptionTestClass

    sut.run()

    Assert.areEqual(sut.expectFailure, sut.failTotal)
  }
}