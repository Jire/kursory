package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.fixed.FixedListIntCursor

class IntHeapFixedListCursor(
	override val list: IntHeapFixedList
) : AbstractHeapFixedListCursor(list), FixedListIntCursor {
	
	override val next get() = list[index]
	
}