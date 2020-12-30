package org.jire.kursory.list.fixed.heap

import org.jire.kursory.ObjectCursor

class ObjectHeapFixedListCursor<T : Any>(
	override val list: ObjectHeapFixedList<T>
) : AbstractHeapFixedListCursor(list), ObjectCursor<T> {
	
	override val next get() = list[index]!!
	
}