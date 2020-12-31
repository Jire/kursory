/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.util.unsafe

import org.jire.kursory.util.Memory
import org.jire.kursory.util.unsafe.Unsafe.Companion.unsafe
import java.lang.reflect.Field

object UnsafeMemory : Memory {
	
	override fun allocate(bytes: Long) = unsafe.allocateMemory(bytes)
	override fun free(address: Long) = unsafe.freeMemory(address)
	override fun set(address: Long, bytes: Long, value: Byte) = unsafe.setMemory(address, bytes, value)
	override fun copy(srcBase: Any?, srcOffset: Long, destBase: Any?, destOffset: Long, bytes: Long) =
		unsafe.copyMemory(srcBase, srcOffset, destBase, destOffset, bytes)
	
	override fun copy(srcAddress: Long, destAddress: Long, bytes: Long) =
		unsafe.copyMemory(srcAddress, destAddress, bytes)
	
	override fun copy(srcBase: Long, srcOffset: Long, destBase: Any, destOffset: Long, bytes: Long) {
		val srcAddressBase = srcBase + srcOffset
		
		var offset = 0L
		while (offset < bytes) {
			val valueAddress = srcAddressBase + offset
			val value = unsafe.getLong(valueAddress)
			
			unsafe.putLong(destBase, destOffset + offset, value)
			
			offset += Unsafe.COPY_STRIDE
		}
	}
	
	override fun copy(srcBase: Any, srcOffset: Long, destBase: Long, destOffset: Long, bytes: Long) {
		val destAddressBase = destBase + destOffset
		
		var offset = 0L
		while (offset < bytes) {
			val valueOffset = srcOffset + offset
			val value = unsafe.getLong(srcBase, valueOffset)
			
			val destAddress = destAddressBase + offset
			unsafe.putLong(destAddress, value)
			
			offset += Unsafe.COPY_STRIDE
		}
	}
	
	override fun getInt(address: Long) = unsafe.getInt(address)
	override fun getIntVolatile(address: Long) = unsafe.getIntVolatile(null, address)
	
	override fun putInt(address: Long, value: Int) = unsafe.putInt(address, value)
	override fun putIntVolatile(address: Long, value: Int) = unsafe.putIntVolatile(null, address, value)
	
	override fun compareAndSwapInt(address: Long, expected: Int, value: Int) =
		unsafe.compareAndSwapInt(null, address, expected, value)
	
	override fun compareAndSwapInt(o: Any, address: Long, expected: Int, value: Int) =
		unsafe.compareAndSwapInt(o, address, expected, value)
	
	override fun objectFieldOffset(field: Field) = unsafe.objectFieldOffset(field)
	
}