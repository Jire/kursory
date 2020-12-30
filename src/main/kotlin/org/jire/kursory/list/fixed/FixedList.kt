package org.jire.kursory.list.fixed

import org.jire.kursory.list.List

interface FixedList<C : FixedListCursor> : List<C> {
	
	val capacity: Int
	
	val lastIndex: Int get() = capacity - 1
	
	override val size get() = capacity
	
}