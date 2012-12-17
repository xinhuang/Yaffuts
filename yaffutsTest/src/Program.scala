import yaffuts._

object Program {
  def main(argv: Array[String]) {
    Test.register(classOf[TestUnitTest])
    Test.register(classOf[AssertionUnitTest])

    Test.run()
  }
}
