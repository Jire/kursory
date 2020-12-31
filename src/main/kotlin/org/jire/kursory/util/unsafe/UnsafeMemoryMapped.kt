package org.jire.kursory.util.unsafe

import org.jire.kursory.util.MemoryMapped
import java.nio.channels.FileChannel

object UnsafeMemoryMapped : MemoryMapped {
	
	override fun map(fileChannel: FileChannel, mode: FileChannel.MapMode, start: Long, size: Long): Long {
		TODO("Not yet implemented")
	}
	
	override fun unmap(address: Long, size: Long) {
		TODO("Not yet implemented")
	}
	
}