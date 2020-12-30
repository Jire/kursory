package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.Cursor

abstract class AbstractThreadSafeOffHeapFixedList<C : Cursor>(
	capacity: Int,
	valueSize: Long
) : AbstractOffHeapFixedList<C>(capacity, valueSize) {
	
	@Volatile
	override var nextIndex: Int = 0
	
	@Volatile
	override var highestIndex: Int = 0
	
}