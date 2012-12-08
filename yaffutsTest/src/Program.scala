import yaffuts._

object Program {
  def main(argv:Array[String]) {
    Test.register(new TestUnitTest())
    Test.register(new AssertionUnitTest())

    Test.run()
  }
}
