package yaffuts

import java.util

class TestMethod(val name:String, val method:()=>Unit) {}

class TestMethods extends util.ArrayList[TestMethod] {
  def add(name:String, method:()=>Unit):Unit = add(new TestMethod(name, method))
}
