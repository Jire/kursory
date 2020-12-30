package org.jire.kursory.list

import org.jire.kursory.Collection
import org.jire.kursory.Cursor

interface List<C : Cursor> : Collection<C> {
	
	fun removeAt(index: Int): Boolean
	
}