package org.jire.kursory

interface Cursor {
	
	fun hasNext(): Boolean
	
	fun moveNext(): Boolean
	
}