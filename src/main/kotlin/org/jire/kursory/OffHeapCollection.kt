package org.jire.kursory

import java.io.File

interface OffHeapCollection<C : Cursor> : Collection<C> {
	
	val persistTo: File? get() = null
	
	fun retain(): Int
	
	fun release(): Boolean
	
}