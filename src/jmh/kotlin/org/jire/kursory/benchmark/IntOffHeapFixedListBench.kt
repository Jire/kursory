/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.benchmark

import org.jire.kursory.list.IntLists.forEach
import org.jire.kursory.list.fixed.offheap.IntOffHeapFixedList
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.ThreadLocalRandom

@State(Scope.Benchmark)
open class IntOffHeapFixedListBench
@JvmOverloads constructor(override val list: IntOffHeapFixedList = IntOffHeapFixedList(CAPACITY)) : Bench(list) {
	
	@Benchmark
	override fun get(blackhole: Blackhole) {
		blackhole.consume(list[current.nextInt(CAPACITY)])
	}
	
	@Benchmark
	override fun add(blackhole: Blackhole) {
		list.add(ThreadLocalRandom.current().nextInt())
	}
	
	@Benchmark
	fun set(blackhole: Blackhole) {
		list[0] = ThreadLocalRandom.current().nextInt()
	}
	
	@Benchmark
	override fun iterate(blackhole: Blackhole) {
		list.forEach { blackhole.consume(it) }
	}
	
}