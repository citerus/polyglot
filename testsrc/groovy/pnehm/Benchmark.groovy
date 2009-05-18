import pnehm.JavaOrderer
import pnehm.GroovyOrderer

jo = new JavaOrderer()
go = new GroovyOrderer()

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

t1 = System.currentTimeMillis()
benchmark(jo)
println "Time Java: ${System.currentTimeMillis() - t1}"

t2 = System.currentTimeMillis()
benchmark(go)
println "Time Groovy: ${System.currentTimeMillis() - t1}"
