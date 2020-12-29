package org.jire.kursory

interface ObjectCollection<T> {
	
	val size: Int
	
	fun isEmpty() = size <= 0
	
	fun add(value: T)
	
	fun contains(value: T?): Boolean
	
	fun clear()
	
	fun remove(value: T?): Boolean
	
}