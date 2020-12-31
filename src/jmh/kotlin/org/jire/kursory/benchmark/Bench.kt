package org.jire.kursory.benchmark

import org.jire.kursory.Collection
import org.jire.kursory.OffHeapCollection
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Fork(Bench.FORKS)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = Bench.WARMUPS, time = Bench.TIME, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = Bench.ITERATIONS, time = Bench.TIME, timeUnit = TimeUnit.MILLISECONDS)
abstract class Bench(open val list: Collection<*>) {
	constructor() : this(TODO())
	
	companion object {
		data class Point(var x: Int = 0, var y: Int = 0)
		
		const val CAPACITY = 10000
		
		const val FORKS = 1
		const val WARMUPS = 1
		const val ITERATIONS = 5
		const val TIME = 100
		
		val flyweight = Point(0, 0)
		val point = Point(0, 0)
	}
	
	val current = ThreadLocalRandom.current()
	
	@Setup
	open fun setup() {
	}
	//list = ObjectOffHeapFixedList(CAPACITY, flyweight/*, File("hey.dat").apply { deleteOnExit() }*/)
	/*for (i in 1..CAPACITY) list.add(
		Point(
			ThreadLocalRandom.current().nextInt(),
			ThreadLocalRandom.current().nextInt()
		)
	)*/
	
	@TearDown
	fun tearDown() {
		(list as? OffHeapCollection<*>)?.free()
	}
	
	abstract fun get(blackhole: Blackhole)
	
	abstract fun add(blackhole: Blackhole)
	
	abstract fun iterate(blackhole: Blackhole)
	
}