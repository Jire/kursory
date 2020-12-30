package org.jire.kursory.list.fixed.heap

import org.jire.kursory.IntCursor

class IntHeapFixedListCursor(
	override val list: IntHeapFixedList
) : AbstractHeapFixedListCursor(list), IntCursor {
	
	override val next get() = list[index]
	
}