/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util

import org.jire.kursory.util.chronicle.ChronicleMemoryMapped
import java.nio.channels.FileChannel
import java.nio.channels.FileChannel.MapMode

interface MemoryMapped {
	
	fun map(fileChannel: FileChannel, mode: MapMode, start: Long, size: Long): Long
	
	fun unmap(address: Long, size: Long)
	
	companion object : MemoryMapped by ChronicleMemoryMapped {
		
		const val MAP_RO = 0
		const val MAP_RW = 1
		const val MAP_PV = 2
		
		val MapMode.imode: Int
			get() = when (this) {
				MapMode.READ_ONLY -> MAP_RO
				MapMode.READ_WRITE -> MAP_RW
				MapMode.PRIVATE -> MAP_PV
				else -> throw UnsupportedOperationException()
			}
		
	}
	
}