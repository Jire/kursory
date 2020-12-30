package org.jire.kursory

interface IntCollection : Collection {
	
	companion object {
		const val NIL = Int.MIN_VALUE
	}
	
	val values: IntArray
	
	fun add(value: Int)
	
	fun contains(value: Int): Boolean
	
	fun remove(value: Int): Boolean
	
	fun addAll(collection: IntCollection) {
		for (value in collection.values) {
			if (value != NIL) {
				add(value)
			}
		}
	}
	
}