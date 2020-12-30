package org.jire.kursory.list.fixed

import org.jire.kursory.list.ListCursor

interface FixedListCursor : ListCursor {
	
	val typedList: FixedList<*>
	
	override val lastIndex get() = typedList.lastIndex - 1
	
}