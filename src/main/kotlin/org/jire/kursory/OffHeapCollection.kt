package org.jire.kursory

import net.openhft.chronicle.core.io.ReferenceCounted
import net.openhft.chronicle.core.io.ReferenceOwner
import java.io.File
import kotlin.concurrent.thread

interface OffHeapCollection<C : Cursor> : Collection<C>, ReferenceCounted {
	
	val persistTo: File? get() = null
	
	fun initialize()
	
	fun free() = clear()
	
	fun freeOnExit() = Runtime.getRuntime().addShutdownHook(thread(false) { free() })
	
	override fun reserve(id: ReferenceOwner?) {
		TODO("Not yet implemented")
	}
	
	override fun tryReserve(id: ReferenceOwner?): Boolean {
		TODO("Not yet implemented")
	}
	
	override fun reservedBy(owner: ReferenceOwner?): Boolean {
		TODO("Not yet implemented")
	}
	
	override fun release(id: ReferenceOwner?) {
		TODO("Not yet implemented")
	}
	
	override fun releaseLast(id: ReferenceOwner?) {
		TODO("Not yet implemented")
	}
	
	override fun refCount(): Int {
		TODO("Not yet implemented")
	}
	
}