package yaffuts

import java.util

class ArrayListEx[T](self:util.ArrayList[T]) {
  def apply(i:Int) = self.get(i)

  def each(action:(T)=>Unit) {
    for (i <- 0 until self.size) {
      action(this(i))
    }
  }

  def select(prediction: (T) => Boolean)  = {
    val result= new util.ArrayList[T]()
    this.each(o => {
      if (prediction(o))
        result.add(o)
    })
    result
  }

}

object ArrayListEx {
  implicit def conversion[T](self:util.ArrayList[T]):ArrayListEx[T] = {
    new ArrayListEx[T](self)
  }
}