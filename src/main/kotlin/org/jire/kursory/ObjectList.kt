package org.jire.kursory

interface ObjectList<T> : ObjectCollection<T> {
	
	val values: Array<T?>
	
	operator fun get(index: Int): T? {
		if (index < 0) return null
		if (index >= values.size) return null
		return values[index]
	}
	
	operator fun set(index: Int, value: T?): Boolean
	
	fun indexOf(value: T?): Int
	
	override fun contains(value: T?) = indexOf(value) >= 0
	
	fun removeAt(index: Int) = set(index, null)
	
	override fun remove(value: T?): Boolean {
		val index = indexOf(value)
		return index != -1 && removeAt(index)
	}
	
	fun addAll(collection: ObjectList<T>) {
		for (value in collection.values) {
			add(value ?: continue)
		}
	}
	
}