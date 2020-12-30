package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.ObjectCursor
import org.jire.kursory.list.ObjectList
import java.util.*
import kotlin.reflect.KClass

class FixedObjectOffHeapList<T : Any>(
	capacity: Int,
	val type: KClass<T>,
	preferThreadSafety: Boolean = false,
) : AbstractFixedOffHeapList<ObjectCursor<T>>(capacity, preferThreadSafety, -1L),
	ObjectList<T> {
	
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
	
	override val cursor = FixedObjectOffHeapListCursor(this)
	
	override fun clear() {
		Arrays.fill(values, null)
	}
	
}