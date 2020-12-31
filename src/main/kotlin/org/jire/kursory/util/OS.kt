/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util

import org.jire.kursory.util.unsafe.UnsafeOS

interface OS {
	
	val mapAlignment: Long
	
	val pageSize: Int
	
	fun mapAlign(offset: Long): Long
	
	companion object : OS by UnsafeOS
	
}