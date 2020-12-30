package org.jire.kursory

import org.jire.kursory.list.ObjectList

interface ObjectCollection<T> : Collection {
	
	val values: Array<T?>
	
	fun add(value: T)
	
	fun contains(value: T?): Boolean
	
	fun remove(value: T?): Boolean
	
	fun addAll(collection: ObjectList<T>) {
		for (value in collection.values) {
			add(value ?: continue)
		}
	}
	
}