package org.jire.kursory

interface IntCollection<C : IntCursor> : Collection<C> {
	
	val nil get() = cursor.nil
	
	fun add(value: Int): Boolean {
		if (canAdd(value)) {
			addUnsafe(value)
			return true
		}
		return false
	}
	
	fun canAdd(value: Int): Boolean
	
	fun addUnsafe(value: Int)
	
	fun contains(value: Int): Boolean
	
	fun remove(value: Int): Boolean
	
}