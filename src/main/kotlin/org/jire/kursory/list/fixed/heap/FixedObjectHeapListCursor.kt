package org.jire.kursory.list.fixed.heap

import org.jire.kursory.ObjectCursor

class FixedObjectHeapListCursor<T : Any>(
	override val list: FixedObjectHeapList<T>
) : AbstractFixedHeapListCursor(list), ObjectCursor<T> {
	
	override val next get() = list[index]!!
	
}