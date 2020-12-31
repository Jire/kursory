/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory

interface ObjectCollection<T, C : ObjectCursor<T>> : Collection<C> {
	
	fun add(value: T): Boolean {
		if (canAdd(value)) {
			addNoCheck(value)
			return true
		}
		return false
	}
	
	fun canAdd(value: T?): Boolean
	
	fun addNoCheck(value: T?)
	
	fun contains(value: T?): Boolean
	
	fun remove(value: T?): Boolean
	
}