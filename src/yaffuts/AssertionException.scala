package yaffuts

class AssertionException(message:String) extends Exception{
  def this() = { this("") }

  override def getMessage = message
}
