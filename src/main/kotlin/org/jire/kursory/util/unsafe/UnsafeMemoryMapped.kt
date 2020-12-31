/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

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