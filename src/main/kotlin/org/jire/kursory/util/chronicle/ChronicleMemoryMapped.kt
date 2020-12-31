package org.jire.kursory.util.chronicle

import net.openhft.chronicle.core.OS
import org.jire.kursory.util.MemoryMapped
import java.nio.channels.FileChannel

object ChronicleMemoryMapped : MemoryMapped {
	
	override fun map(fileChannel: FileChannel, mode: FileChannel.MapMode, start: Long, size: Long) =
		OS.map(fileChannel, mode, start, size)
	
	override fun unmap(address: Long, size: Long) = OS.unmap(address, size)
	
}