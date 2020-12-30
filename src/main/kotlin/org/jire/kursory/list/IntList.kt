package org.jire.kursory.list

import org.jire.kursory.IntCollection
import org.jire.kursory.IntCollection.Companion.NIL

interface IntList : IntCollection, List {
	
	operator fun get(index: Int): Int {
		if (index < 0) return NIL
		if (index >= values.size) return NIL
		return values[index]
	}
	
	operator fun set(index: Int, value: Int): Boolean
	
	fun indexOf(value: Int): Int
	
	override fun contains(value: Int) = indexOf(value) >= 0
	
	override fun removeAt(index: Int) = set(index, NIL)
	
	override fun remove(value: Int): Boolean {
		val index = indexOf(value)
		return index != -1 && removeAt(index)
	}
	
}