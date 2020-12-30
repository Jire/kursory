package org.jire.kursory

interface IntCursor : Cursor {
	
	companion object {
		const val NIL = Int.MIN_VALUE
	}
	
	val nil get() = NIL
	
}