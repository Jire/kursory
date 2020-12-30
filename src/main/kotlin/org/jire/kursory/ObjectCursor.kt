package org.jire.kursory

interface ObjectCursor<T> : Cursor {
	
	val next: T
	
}