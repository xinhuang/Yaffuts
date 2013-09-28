package yaffuts

private[yaffuts] class AssertionException(message: String) extends Exception(message) {
  def this() = this("")
}
