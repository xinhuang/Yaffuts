package yaffuts

import java.util.ArrayList

class TestMethod(val name:String, val method:()=>Unit) {
  var errorMessage:String = ""
  var isSuccessfull:Boolean = true
}

class TestMethods extends ArrayList[TestMethod] {
  def add(name:String, method:()=>Unit):Unit = add(new TestMethod(name, method))
}
