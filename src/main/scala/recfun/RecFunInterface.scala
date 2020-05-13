package recfun



/**
 * The interface used by the grading infrastructure. Do not change signatures
 * or your submission will fail with a NoSuchMethodError.
 */
trait RecFunInterface {
  /*def pascal(c: Int, r: Int): Int
  def balance(chars: List[Char]): Boolean
  def countChange(money: Int, coins: List[Int]): Int*/

  // Reg. Problems #3, #10
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var x: Int = _x
    var next: ListNode = _next
  }

  // Reg. Problem #10, Reorder List
  object ListNode {
    def unapply(node: ListNode): Option[Int] = Some(node.x)
  }

}

