package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.List
import org.jire.kursory.list.fixed.FixedIntList
import java.util.*

class IntHeapFixedList(capacity: Int) : AbstractHeapFixedList<IntHeapFixedListCursor>(capacity),
	FixedIntList<IntHeapFixedListCursor> {
	
	val values = IntArray(capacity)
	
	var nextIndex = 0
	
	override fun get(index: Int) = values[index]
	
	override fun set(index: Int, value: Int): Boolean {
		values[index] = value
		return true
	}
	
	override fun indexOf(value: Int): Int {
		for (index in 0..values.lastIndex) {
			if (value == values[index]) {
				return index
			}
		}
		return List.INVALID_INDEX
	}
	
	override fun canAdd(value: Int) = nextIndex < lastIndex
	
	override fun addNoCheck(value: Int) {
		values[nextIndex++] = value
	}
	
	override val cursor = IntHeapFixedListCursor(this)
	
	override fun clear() {
		Arrays.fill(values, nil)
	}
	
}