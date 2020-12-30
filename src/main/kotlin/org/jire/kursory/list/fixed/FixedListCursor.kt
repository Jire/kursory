package org.jire.kursory.list.fixed

import org.jire.kursory.list.ListCursor

interface FixedListCursor : ListCursor {
	
	override val list: FixedList<*>
	
	override val lastIndex get() = list.lastIndex - 1
	
}