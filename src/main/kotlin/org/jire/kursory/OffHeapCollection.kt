package org.jire.kursory

import java.io.File

interface OffHeapCollection<C : Cursor> : Collection<C> {
	
	val persistTo: File? get() = null
	
	fun initialize()
	
	fun free() = clear()
	
	fun retain(): Int
	
	fun release(): Boolean
	
}