package org.jire.kursory

import java.io.File
import kotlin.concurrent.thread

interface OffHeapCollection<C : Cursor> : Collection<C>, ReferenceCounted {
	
	val persistTo: File? get() = null
	
	fun initialize()
	
	fun free() = clear()
	
	fun freeOnExit() = Runtime.getRuntime().addShutdownHook(thread(false) { free() })
	
}