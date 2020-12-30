package org.jire.kursory.list

import org.jire.kursory.Collection

interface List<C : ListCursor> : Collection<C> {
	
	companion object {
		const val INVALID_INDEX = -1
	}
	
	fun removeAt(index: Int): Boolean
	
}