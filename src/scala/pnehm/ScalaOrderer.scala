package pnehm

import java.lang.String
import java.util._
import org.apache.commons.collections.bag.HashBag

class ScalaOrderer extends Orderer {
  def orderByFreq(in: List[String]): List[String] = {
    val bag = new HashBag(in)
    val out: List[String] = new ArrayList[String](bag.uniqueSet.asInstanceOf[Set[String]])

    Collections.sort(out, new Comparator[String] {
      def compare(a: String, b: String): Int = {
        def freq = bag.getCount(b).compare(bag.getCount(a))
        if (freq != 0) freq else a.compare(b)
      }
    })
    return out
  }
}