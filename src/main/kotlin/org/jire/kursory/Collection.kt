package org.jire.kursory

interface Collection<C : Cursor> {
	
	val preferThreadSafety: Boolean get() = false
	
	val cursor: C
	
	val size: Int
	
	fun isEmpty() = size <= 0
	
	fun clear()
	
}