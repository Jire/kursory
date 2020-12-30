package org.jire.kursory

interface Collection {
	
	val size: Int
	
	fun isEmpty() = size <= 0
	
	fun clear()
	
}