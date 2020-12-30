package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.IntCursor

class IntOffHeapFixedListCursor(
	override val list: IntOffHeapFixedList
) : AbstractOffHeapFixedListCursor(list),
	IntCursor {
	
	override val next get() = list[index]
	
}