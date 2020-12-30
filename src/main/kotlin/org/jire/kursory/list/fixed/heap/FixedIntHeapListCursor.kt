package org.jire.kursory.list.fixed.heap

import org.jire.kursory.IntCursor

class FixedIntHeapListCursor(
	override val list: FixedIntHeapList
) : AbstractFixedHeapListCursor(list), IntCursor {
	
	override val next get() = list[index]
	
}