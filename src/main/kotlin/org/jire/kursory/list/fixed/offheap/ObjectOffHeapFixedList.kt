/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.Jvm
import org.jire.kursory.list.fixed.FixedObjectList
import org.jire.kursory.util.ClassMemory
import org.jire.kursory.util.Memory

class ObjectOffHeapFixedList<T : Any>(
	capacity: Int,
	val flyweight: T,
	val type: Class<T> = flyweight.javaClass,
) : AbstractOffHeapFixedList<ObjectOffHeapFixedListCursor<T>>(capacity, ClassMemory(type).size),
	FixedObjectList<T, ObjectOffHeapFixedListCursor<T>> {
	
	override fun get(index: Int) = flyweight.apply {
		Memory.copy(pointer(index), this, valueSize)
	}
	
	override fun set(index: Int, value: T?): Boolean {
		val pointer = pointer(index)
		when {
			value == null -> Memory.set(pointer, valueSize, 0)
			Jvm.isJava9Plus() -> Memory.copy(value, pointer, valueSize)
			else -> Memory.copy(value, 0, null, pointer, valueSize)
		}
		return true
	}
	
	override fun indexOf(value: T?): Int {
		TODO("Not yet implemented")
	}
	
	override fun canAdd(value: T?) = nextIndex <= lastIndex
	
	override fun addNoCheck(value: T?) {
		set(nextIndex++, value)
	}
	
	override val cursor = ObjectOffHeapFixedListCursor(this)
	
	override fun initialize() {}
	
}