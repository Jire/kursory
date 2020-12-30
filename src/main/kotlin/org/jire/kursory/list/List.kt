package org.jire.kursory.list

import org.jire.kursory.Collection
import org.jire.kursory.Cursor

interface List<C : Cursor> : Collection<C> {
	
	companion object {
		const val INVALID_INDEX = -1
	}
	
	fun removeAt(index: Int): Boolean
	
}