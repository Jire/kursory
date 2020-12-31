/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util

import java.lang.reflect.Field
import java.lang.reflect.Modifier

object Fields {
	
	val Field.isStatic get() = modifiers and Modifier.STATIC == 0
	
	val Field.memoryOffset get() = Memory.objectFieldOffset(this)
	
	inline fun <reified T> T.getFieldOffset(fieldName: String) = T::class.java.getDeclaredField(fieldName).memoryOffset
	
}