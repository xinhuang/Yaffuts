package yaffuts

import java.util

class ArrayListEx[T](self:util.ArrayList[T]) {
  def apply(i:Int) = self.get(i)
}

object ArrayListEx {
  implicit def conversion[T](self:util.ArrayList[T]):ArrayListEx[T] = {
    return new ArrayListEx[T](self)
  }
}