import pnehm.JavaOrderer
import pnehm.GroovyOrderer
import pnehm.ScalaOrderer

jo = new JavaOrderer()
go = new GroovyOrderer()
co1 = new step3.pnehm.ClojureOrderer()
co2 = new withcontrib.pnehm.ClojureOrderer()

so = new ScalaOrderer()

alphabet = "abcdefghijklmnopqrstuvwxyz"
random = new Random()

unordered = []
100.times {
    def index = random.nextInt(alphabet.length()) 
    unordered << alphabet[index]
}

def benchmark = { o ->
    10000.times {
        o.orderByFreq(new ArrayList(unordered))
    }
}

// Warmup
benchmark(jo)
benchmark(go)
benchmark(co1)
benchmark(co2)
benchmark(so)

t1 = System.currentTimeMillis()
benchmark(jo)
println "Time Java: ${System.currentTimeMillis() - t1}"

t2 = System.currentTimeMillis()
benchmark(go)
println "Time Groovy: ${System.currentTimeMillis() - t2}"

t3 = System.currentTimeMillis()
benchmark(co1)
println "Time Clojure: ${System.currentTimeMillis() - t3}"

t4 = System.currentTimeMillis()
benchmark(co2)
println "Time Clojure (with 'frequencies'): ${System.currentTimeMillis() - t4}"

t5 = System.currentTimeMillis()
benchmark(so)
println "Time Scala: ${System.currentTimeMillis() - t5}"