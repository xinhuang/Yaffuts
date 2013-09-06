package yaffuts

import java.util

class TestMethodCollection(methods: (String, () => Unit)*) extends util.ArrayList[TestMethod] {
  methods.foreach(tuple => add(tuple._1, tuple._2))

  def add(name: String, method: () => Unit) {
    add(new TestMethod(name, method))
  }
}
