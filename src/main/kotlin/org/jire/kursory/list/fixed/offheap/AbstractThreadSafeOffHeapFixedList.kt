package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.fixed.FixedListCursor

abstract class AbstractThreadSafeOffHeapFixedList<C : FixedListCursor>(
	capacity: Int,
	valueSize: Long
) : AbstractOffHeapFixedList<C>(capacity, valueSize) {
	
	@Volatile
	override var nextIndex: Int = 0
	
	@Volatile
	override var highestIndex: Int = 0
	
}