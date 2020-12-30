package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.fixed.FixedListObjectCursor

class ObjectHeapFixedListCursor<T : Any>(
	override val list: ObjectHeapFixedList<T>
) : AbstractHeapFixedListCursor(list), FixedListObjectCursor<T> {
	
	override val next get() = list[index]!!
	
}