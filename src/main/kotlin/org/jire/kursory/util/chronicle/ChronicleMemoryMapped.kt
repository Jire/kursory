/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util.chronicle

import net.openhft.chronicle.core.OS
import org.jire.kursory.util.MemoryMapped
import java.nio.channels.FileChannel

object ChronicleMemoryMapped : MemoryMapped {
	
	override fun map(fileChannel: FileChannel, mode: FileChannel.MapMode, start: Long, size: Long) =
		OS.map(fileChannel, mode, start, size)
	
	override fun unmap(address: Long, size: Long) = OS.unmap(address, size)
	
}