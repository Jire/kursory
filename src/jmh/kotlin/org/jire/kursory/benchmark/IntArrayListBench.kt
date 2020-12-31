/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Fork(Bench.FORKS)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = Bench.WARMUPS, time = Bench.TIME, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = Bench.ITERATIONS, time = Bench.TIME, timeUnit = TimeUnit.MILLISECONDS)
open class IntArrayListBench {
	
	val list = ArrayList<Int>(Bench.CAPACITY)
	
	@Setup
	fun setup() {
		for (i in 1..Bench.CAPACITY) list.add(ThreadLocalRandom.current().nextInt())
	}
	
	@Benchmark
	fun get(blackhole: Blackhole) {
		blackhole.consume(list[ThreadLocalRandom.current().nextInt(Bench.CAPACITY)])
	}
	
	@Benchmark
	fun add(blackhole: Blackhole) {
		list.add(ThreadLocalRandom.current().nextInt())
	}
	
	@Benchmark
	fun set(blackhole: Blackhole) {
		list[0] = ThreadLocalRandom.current().nextInt()
	}
	
	@Benchmark
	fun iterate(blackhole: Blackhole) {
		list.forEach { blackhole.consume(it) }
	}
	
}