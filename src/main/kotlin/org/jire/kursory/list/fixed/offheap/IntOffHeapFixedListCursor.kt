package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.fixed.FixedListIntCursor

class IntOffHeapFixedListCursor(
	override val list: IntOffHeapFixedList
) : AbstractOffHeapFixedListCursor(list),
	FixedListIntCursor {
	
	override val next get() = list[index]
	
}