package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.IntCursor

class FixedIntOffHeapListCursor(
	override val list: FixedIntOffHeapList
) : AbstractFixedOffHeapListCursor(list),
	IntCursor {
	
	override val next get() = list[index]
	
}