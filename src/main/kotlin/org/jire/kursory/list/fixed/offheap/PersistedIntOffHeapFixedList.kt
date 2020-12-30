package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.OS
import java.io.File
import java.io.RandomAccessFile
import java.nio.channels.FileChannel

class PersistedIntOffHeapFixedList(
	capacity: Int,
	persistTo: File
) : ThreadSafeIntOffHeapFixedList(capacity) {
	constructor(capacity: Int, persistTo: String) : this(capacity, File(persistTo))
	
	val raf = RandomAccessFile(persistTo, "rw")
	
	override val address = OS.map(
		raf.channel,
		FileChannel.MapMode.READ_WRITE,
		0L,
		addressSpace
	)
	
	override fun free() {
		OS.unmap(address, addressSpace)
		raf.close()
	}
	
	override fun initialize() {}
	
}