package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.fixed.FixedListObjectCursor

class ObjectOffHeapFixedListCursor<T : Any>(
	override val list: ObjectOffHeapFixedList<T>
) : AbstractOffHeapFixedListCursor(list),
	FixedListObjectCursor<T> {
	
	override val next get() = list[index]!!
	
}