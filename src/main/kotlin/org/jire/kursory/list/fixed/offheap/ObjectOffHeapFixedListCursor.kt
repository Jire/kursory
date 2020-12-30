package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.ObjectCursor

class ObjectOffHeapFixedListCursor<T : Any>(
	override val list: ObjectOffHeapFixedList<T>
) : AbstractOffHeapFixedListCursor(list),
	ObjectCursor<T> {
	
	override val next get() = list[index]!!
	
}