package org.jire.kursory

interface ObjectCollection<T, C : ObjectCursor<T>> : Collection<C> {
	
	fun add(value: T): Boolean {
		if (canAdd(value)) {
			addNoCheck(value)
			return true
		}
		return false
	}
	
	fun canAdd(value: T?): Boolean
	
	fun addNoCheck(value: T?)
	
	fun contains(value: T?): Boolean
	
	fun remove(value: T?): Boolean
	
}