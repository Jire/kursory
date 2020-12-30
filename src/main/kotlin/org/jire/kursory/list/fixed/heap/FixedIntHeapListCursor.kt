package org.jire.kursory.list.fixed.heap

import org.jire.kursory.IntCursor

class FixedIntHeapListCursor(
	override val typedList: FixedIntHeapList
) : AbstractFixedHeapListCursor(typedList), IntCursor {
	
	override val next get() = typedList[index]
	
}