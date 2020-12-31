/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list

import org.jire.kursory.Cursor

interface ListCursor : Cursor {
	
	val list: List<*>
	
	var index: Int
	val lastIndex: Int
	
	override fun hasNext() = index <= lastIndex
	
	override fun moveNext(): Boolean {
		if (hasNext()) {
			index++
			return true
		}
		return false
	}
	
}