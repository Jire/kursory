package org.jire.kursory.list

import org.jire.kursory.IntCollection

interface IntList<C : ListIntCursor> : IntCollection<C>, List<C> {
	
	operator fun get(index: Int): Int
	
	operator fun set(index: Int, value: Int): Boolean
	
	fun indexOf(value: Int): Int
	
	override fun contains(value: Int) = indexOf(value) >= 0
	
	override fun removeAt(index: Int) = set(index, nil)
	
	override fun remove(value: Int): Boolean {
		val index = indexOf(value)
		return index != List.INVALID_INDEX && removeAt(index)
	}
	
	fun addAll(list: IntList<out C>) {
		val cursor = list.cursor
		while (cursor.moveNext()) {
			add(cursor.next)
		}
	}
	
}