package yaffuts

import java.util
import yaffuts.ArrayListEx._

class ArrayListEx[T](self:util.ArrayList[T]) {
  def apply(i:Int) = self.get(i)

  def each(action:(T)=>Unit) = {
    for (i <- 0 until self.size) {
      action(self(i))
    }
  }
}

object ArrayListEx {
  implicit def conversion[T](self:util.ArrayList[T]):ArrayListEx[T] = {
    return new ArrayListEx[T](self)
  }
}