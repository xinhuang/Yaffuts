package yaffuts

class TestMethod(val name: String, val method: () => Unit) {
  def printErrorMessage() {
    println("Failed: " + name)
    println(errorMessage + ":")
    stackTrace.foreach(o => printf("\tat %s.%s(%s:%d)\n",
      o.getClassName, o.getMethodName,
      o.getFileName, o.getLineNumber))
  }

  var stackTrace: Seq[StackTraceElement] = Seq()

  var errorMessage = ""
  var isSuccessful = true
}
