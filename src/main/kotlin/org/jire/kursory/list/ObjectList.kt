package org.jire.kursory.list

import org.jire.kursory.ObjectCollection

interface ObjectList<T> : ObjectCollection<T>, List {
	
	operator fun get(index: Int): T? {
		if (index < 0) return null
		if (index >= values.size) return null
		return values[index]
	}
	
	operator fun set(index: Int, value: T?): Boolean
	
	fun indexOf(value: T?): Int
	
	override fun contains(value: T?) = indexOf(value) >= 0
	
	override fun removeAt(index: Int) = set(index, null)
	
	override fun remove(value: T?): Boolean {
		val index = indexOf(value)
		return index != -1 && removeAt(index)
	}
	
}