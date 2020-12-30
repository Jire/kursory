package org.jire.kursory

import org.jire.kursory.list.ObjectList

interface ObjectCollection<T> : Collection<ObjectCursor<T>> {
	
	fun add(value: T): Boolean {
		if (canAdd(value)) {
			addUnsafe(value)
			return true
		}
		return false
	}
	
	fun canAdd(value: T?): Boolean
	
	fun addUnsafe(value: T?)
	
	fun contains(value: T?): Boolean
	
	fun remove(value: T?): Boolean
	
	fun addAll(collection: ObjectList<T>) {
		val cursor = collection.cursor
		while (cursor.moveNext()) {
			addUnsafe(cursor.next)
		}
	}
	
}