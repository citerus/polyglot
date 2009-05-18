package pnehm

import org.apache.commons.collections.bag.HashBag

class GroovyOrderer implements Orderer {

    List<String> orderByFreq(List<String> inList) {
     def bag = new HashBag(inList)
     def out = bag.uniqueSet() as List

     out.sort { a, b ->
         def freq = bag.getCount(b) <=> bag.getCount(a)
         freq != 0 ? freq : a <=> b
     }

    }

}