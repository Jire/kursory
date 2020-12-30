package org.jire.kursory.list.fixed.heap

import org.jire.kursory.ObjectCursor

class FixedObjectHeapListCursor<T : Any>(
	override val typedList: FixedObjectHeapList<T>
) : AbstractFixedHeapListCursor(typedList), ObjectCursor<T> {
	
	override val next get() = typedList[index]!!
	
}