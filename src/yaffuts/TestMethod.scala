package yaffuts

import java.util

class TestMethod(val name: String, val method: () => Unit) {
  def printErrorMessage() {
    println("Failed: " + name)
    println(errorMessage + ":")
    stackTrace.foreach(o => printf("\tat %s.%s(%s:%d)\n",
                                   o.getClassName, o.getMethodName,
                                   o.getFileName, o.getLineNumber))
  }

  var stackTrace: Array[StackTraceElement] = null

  var errorMessage: String = ""
  var isSuccessful: Boolean = true
}

class TestMethods(methods: (String, () => Unit)*) extends util.ArrayList[TestMethod] {
  methods.foreach(tuple => add(tuple._1, tuple._2))

  def add(name: String, method: () => Unit) {
    add(new TestMethod(name, method))
  }
}
