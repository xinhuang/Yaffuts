package yaffuts

import scala.collection.mutable.ArrayBuffer

class TestMethodCollection(methods: (String, () => Unit)*) extends ArrayBuffer[TestMethod] {
  methods.foreach(tuple => add(tuple._1, tuple._2))

  def add(name: String, method: () => Unit) {
    this += new TestMethod(name, method)
  }
}
