package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.List
import org.jire.kursory.list.fixed.FixedObjectList
import java.util.*
import kotlin.reflect.KClass

class ObjectHeapFixedList<T : Any>(
	capacity: Int,
	val type: KClass<T>
) : AbstractHeapFixedList<ObjectHeapFixedListCursor<T>>(capacity),
	FixedObjectList<T, ObjectHeapFixedListCursor<T>> {
	
	val values: Array<T?> = TODO()
	
	var nextIndex = 0
	
	override fun get(index: Int) = values[index]
	
	override fun set(index: Int, value: T?): Boolean {
		values[index] = value
		return true
	}
	
	override fun indexOf(value: T?): Int {
		value ?: return List.INVALID_INDEX
		for (index in 0..values.lastIndex) {
			if (value == values[index]) {
				return index
			}
		}
		return List.INVALID_INDEX
	}
	
	override fun canAdd(value: T?) = nextIndex <= lastIndex
	
	override fun addNoCheck(value: T?) {
		values[nextIndex++] = value
	}
	
	override val cursor = ObjectHeapFixedListCursor(this)
	
	override fun clear() {
		Arrays.fill(values, null)
	}
	
}