package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.fixed.FixedListIntCursor

class ThreadSafeIntOffHeapFixedListCursor(
	override val list: ThreadSafeIntOffHeapFixedList
) : AbstractOffHeapFixedListCursor(list),
	FixedListIntCursor {
	
	override val next get() = list[index]
	
}