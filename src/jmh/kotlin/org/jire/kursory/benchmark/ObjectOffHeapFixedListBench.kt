package org.jire.kursory.benchmark

import org.jire.kursory.benchmark.Bench.Companion.Point
import org.jire.kursory.list.ObjectLists.forEach
import org.jire.kursory.list.fixed.offheap.ObjectOffHeapFixedList
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole

open class ObjectOffHeapFixedListBench
@JvmOverloads constructor(
	override val list: ObjectOffHeapFixedList<Point> = ObjectOffHeapFixedList(
		CAPACITY,
		Point()
	)
) : Bench(list) {
	
	@Benchmark
	override fun get(blackhole: Blackhole) {
		blackhole.consume(list[current.nextInt(CAPACITY)])
	}
	
	@Benchmark
	override fun add(blackhole: Blackhole) {
		list.add(point)
	}
	
	@Benchmark
	fun set(blackhole: Blackhole) {
		list[0] = Bench.point
	}
	
	@Benchmark
	override fun iterate(blackhole: Blackhole) {
		list.forEach { blackhole.consume(it) }
	}
	
}