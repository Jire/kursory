package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.ObjectCursor

class FixedObjectOffHeapListCursor<T : Any>(
	override val list: FixedObjectOffHeapList<T>
) : AbstractFixedOffHeapListCursor(list),
	ObjectCursor<T> {
	
	override val next get() = list[index]!!
	
}