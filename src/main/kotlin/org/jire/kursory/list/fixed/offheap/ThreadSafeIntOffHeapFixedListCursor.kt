package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.IntCursor

class ThreadSafeIntOffHeapFixedListCursor(
	override val list: ThreadSafeIntOffHeapFixedList
) : AbstractOffHeapFixedListCursor(list),
	IntCursor {
	
	override val next get() = list[index]
	
}