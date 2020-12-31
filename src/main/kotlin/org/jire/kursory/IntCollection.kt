/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory

interface IntCollection<C : IntCursor> : Collection<C> {
	
	val nil get() = cursor.nil
	
	fun add(value: Int): Boolean {
		if (canAdd(value)) {
			addNoCheck(value)
			return true
		}
		return false
	}
	
	fun canAdd(value: Int): Boolean
	
	fun addNoCheck(value: Int)
	
	fun contains(value: Int): Boolean
	
	fun remove(value: Int): Boolean
	
}