/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory

interface Collection<C : Cursor> {
	
	val cursor: C
	
	val size: Int
	
	fun isEmpty() = size <= 0
	
	fun clear()
	
}