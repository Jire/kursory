package org.jire.kursory.list

import org.jire.kursory.Cursor

interface ListCursor : Cursor {
	
	val list: List<*>
	
	var index: Int
	val lastIndex: Int
	
	override fun hasNext() = index < lastIndex
	
	override fun moveNext(): Boolean {
		if (hasNext()) {
			index++
			return true
		}
		return false
	}
	
}