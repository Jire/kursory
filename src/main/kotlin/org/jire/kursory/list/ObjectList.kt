package org.jire.kursory.list

import org.jire.kursory.ObjectCollection

interface ObjectList<T, C : ListObjectCursor<T>> : ObjectCollection<T, C>, List<C> {
	
	operator fun get(index: Int): T?
	
	operator fun set(index: Int, value: T?): Boolean
	
	fun indexOf(value: T?): Int
	
	override fun contains(value: T?) = indexOf(value) >= 0
	
	override fun removeAt(index: Int) = set(index, null)
	
	override fun remove(value: T?): Boolean {
		val index = indexOf(value)
		return index != -1 && removeAt(index)
	}
	
	fun addAll(collection: ObjectList<out T, out C>) {
		val cursor = collection.cursor
		while (cursor.moveNext()) {
			addNoCheck(cursor.next)
		}
	}
	
}