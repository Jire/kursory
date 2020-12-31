package org.jire.kursory.util.unsafe

import org.jire.kursory.util.OS

object UnsafeOS : OS {
	
	override val mapAlignment: Long
		get() = TODO("Not yet implemented")
	override val pageSize: Int
		get() = TODO("Not yet implemented")
	
	override fun mapAlign(offset: Long): Long {
		val chunkMultiple = mapAlignment.toInt()
		return (offset + chunkMultiple - 1) / chunkMultiple * chunkMultiple
	}
	
}