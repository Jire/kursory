package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.IntCursor

class FixedIntOffHeapListCursor(
	override val typedList: FixedIntOffHeapList
) : AbstractFixedOffHeapListCursor(typedList), IntCursor {
	
	override val next get() = typedList[index]
	
}