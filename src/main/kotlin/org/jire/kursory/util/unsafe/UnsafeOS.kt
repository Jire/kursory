/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

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