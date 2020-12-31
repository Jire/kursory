/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util

import org.jire.kursory.util.unsafe.UnsafeMemory
import java.lang.reflect.Field

interface Memory {
	
	fun allocate(bytes: Long): Long
	fun free(address: Long)
	fun set(address: Long, bytes: Long, value: Byte)
	
	fun copy(srcAddress: Long, destAddress: Long, bytes: Long)
	
	fun copy(srcBase: Any?, srcOffset: Long, destBase: Any?, destOffset: Long, bytes: Long)
	
	fun copy(srcBase: Long, srcOffset: Long, destBase: Any, destOffset: Long, bytes: Long)
	fun copy(srcBase: Long, destBase: Any, bytes: Long) = copy(srcBase, 0, destBase, 0, bytes)
	
	fun copy(srcBase: Any, srcOffset: Long, destBase: Long, destOffset: Long, bytes: Long)
	fun copy(srcBase: Any, destBase: Long, bytes: Long) = copy(srcBase, 0, destBase, 0, bytes)
	
	fun getInt(address: Long): Int
	fun getIntVolatile(address: Long) = run {
		Fences.load()
		getInt(address)
	}
	
	fun putInt(address: Long, value: Int)
	fun putIntVolatile(address: Long, value: Int)
	
	fun compareAndSwapInt(o: Any, address: Long, expected: Int, value: Int): Boolean
	fun compareAndSwapInt(address: Long, expected: Int, value: Int): Boolean
	
	fun objectFieldOffset(field: Field): Long
	
	operator fun set(address: Long, value: Int) = putInt(address, value)
	
	companion object : Memory by UnsafeMemory {
		
		inline operator fun <reified T> Memory.get(address: Long): T = when (T::class) {
			Int::class -> getInt(address) as T
			else -> throw UnsupportedOperationException("Unsupported get with type ${T::class}")
		}
		
	}
	
}