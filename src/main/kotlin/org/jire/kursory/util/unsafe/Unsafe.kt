/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util.unsafe

import sun.misc.Unsafe as SunUnsafe

interface Unsafe {
	
	companion object : Unsafe {
		
		@JvmStatic
		val unsafe = SunUnsafe::class.java.getDeclaredField("theUnsafe").run {
			isAccessible = true
			get(null) as SunUnsafe
		}
		
		const val COPY_STRIDE = 8L
		
	}
	
}