/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util

import org.jire.kursory.util.Fields.getFieldOffset
import kotlin.reflect.KProperty

class IntCASDelegate<T : Any>(@Volatile private var value: Int = 0) : CASDelegate {
	
	private val valueOffset = getFieldOffset("value")
	
	operator fun getValue(thisRef: T, property: KProperty<*>) = value
	
	operator fun setValue(thisRef: T, property: KProperty<*>, value: Int) {
		while (Memory.compareAndSwapInt(thisRef, valueOffset, this.value, value)) {
			this.value = value
		}
	}
	
}