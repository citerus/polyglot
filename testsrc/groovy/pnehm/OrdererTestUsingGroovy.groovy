package pnehm

class OrdererTestUsingGroovy extends GroovyTestCase {

    private def doTestOrderByFreq(orderer) {
        def unordered = ["b", "d", "b", "b", "a", "c", "a"]
        def ordered = orderer.orderByFreq(unordered)
        assert ["b","a","c","d"] == ordered
    }

    void testJavaImpl() {
        doTestOrderByFreq(new JavaOrderer())
    }

    void testGroovyImpl() {
        doTestOrderByFreq(new GroovyOrderer())
    }

}