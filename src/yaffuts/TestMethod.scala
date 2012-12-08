package yaffuts

import java.util.ArrayList

class TestMethod(val name: String, val method: () => Unit) {
  var errorMessage: String = ""
  var isSuccessful: Boolean = true
}

class TestMethods(methods: (String, () => Unit)*) extends ArrayList[TestMethod] {
  methods.foreach(tuple => add(tuple._1, tuple._2))

  def add(name: String, method: () => Unit) {
    add(new TestMethod(name, method))
  }
}
