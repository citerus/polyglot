package pnehm;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class JavaOrderer implements Orderer {

    public List<String> orderByFreq(List<String> in) {
        final Bag bag = new HashBag(in);
        List<String> out = new ArrayList<String>(bag.uniqueSet());

        Collections.sort(out, new Comparator<String>() {
            public int compare(String a, String b) {
                int freq = Integer.valueOf(
                    bag.getCount(b)).compareTo(bag.getCount(a)
                );
                return freq != 0 ? freq : a.compareTo(b);
            }
        });

        return out;
    }
}
