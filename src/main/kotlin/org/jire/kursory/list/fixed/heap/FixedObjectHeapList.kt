package org.jire.kursory.list.fixed.heap

import org.jire.kursory.ObjectCursor
import org.jire.kursory.list.ObjectList
import java.util.*
import kotlin.reflect.KClass

class FixedObjectHeapList<T : Any>(
	capacity: Int,
	val type: KClass<T>
) : AbstractFixedHeapList<ObjectCursor<T>>(capacity),
	ObjectList<T> {
	
	val values: Array<T?> = TODO()
	
	var nextIndex = 0
	
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
	
	override val cursor = FixedObjectHeapListCursor(this)
	
	override fun clear() {
		Arrays.fill(values, null)
	}
	
}