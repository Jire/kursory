package org.jire.kursory.list

import org.jire.kursory.ObjectCollection
import org.jire.kursory.ObjectCursor

interface ObjectList<T> : ObjectCollection<T>, List<ObjectCursor<T>> {
	
	operator fun get(index: Int): T?
	
	operator fun set(index: Int, value: T?): Boolean
	
	fun indexOf(value: T?): Int
	
	override fun contains(value: T?) = indexOf(value) >= 0
	
	override fun removeAt(index: Int) = set(index, null)
	
	override fun remove(value: T?): Boolean {
		val index = indexOf(value)
		return index != -1 && removeAt(index)
	}
	
}