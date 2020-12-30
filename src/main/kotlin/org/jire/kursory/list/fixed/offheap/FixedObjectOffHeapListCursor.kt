package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.ObjectCursor

class FixedObjectOffHeapListCursor<T : Any>(
	override val typedList: FixedObjectOffHeapList<T>
) : AbstractFixedOffHeapListCursor(typedList), ObjectCursor<T> {
	
	override val next get() = typedList[index]!!
	
}