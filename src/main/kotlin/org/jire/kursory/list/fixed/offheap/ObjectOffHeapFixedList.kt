package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.fixed.FixedObjectList
import java.util.*
import kotlin.reflect.KClass

class ObjectOffHeapFixedList<T : Any>(
	capacity: Int,
	val type: KClass<T>,
) : AbstractOffHeapFixedList<ObjectOffHeapFixedListCursor<T>>(capacity, -1L),
	FixedObjectList<T, ObjectOffHeapFixedListCursor<T>> {
	
	val values: Array<T?> = TODO()
	
	override fun get(index: Int) = values[index]
	
	override fun set(index: Int, value: T?): Boolean {
		values[index] = value
		return true
	}
	
	override fun indexOf(value: T?): Int {
		TODO("Not yet implemented")
	}
	
	override fun canAdd(value: T?) = nextIndex < lastIndex
	
	override fun addUnsafe(value: T?) {
		values[nextIndex++] = value
	}
	
	override val cursor = ObjectOffHeapFixedListCursor(this)
	
	override fun clear() {
		Arrays.fill(values, null)
	}
	
}