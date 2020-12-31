/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.CleaningRandomAccessFile
import org.jire.kursory.util.MemoryMapped
import java.io.File
import java.io.RandomAccessFile
import java.nio.channels.FileChannel

class PersistedIntOffHeapFixedList(
	capacity: Int,
	persistTo: File
) : ThreadSafeIntOffHeapFixedList(capacity) {
	constructor(capacity: Int, persistTo: String) : this(capacity, File(persistTo))
	
	val raf: RandomAccessFile = CleaningRandomAccessFile(persistTo, "rw")
	
	override val address = MemoryMapped.map(
		raf.channel,
		FileChannel.MapMode.READ_WRITE,
		0L,
		addressSpace
	)
	
	override fun free() {
		MemoryMapped.unmap(address, addressSpace)
		raf.close()
	}
	
	override fun initialize() {}
	
}