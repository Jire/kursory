package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.ListCursor

interface FixedHeapListCursor : ListCursor {
	
	val typedList: FixedHeapList<*>
	
	override val lastIndex get() = typedList.lastIndex - 1
	
}