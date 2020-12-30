package org.jire.kursory.list.fixed

import org.jire.kursory.Cursor
import org.jire.kursory.list.List

interface FixedList<C : Cursor> : List<C> {
	
	val capacity: Int
	
	val lastIndex: Int get() = capacity - 1
	
	override val size get() = capacity
	
}