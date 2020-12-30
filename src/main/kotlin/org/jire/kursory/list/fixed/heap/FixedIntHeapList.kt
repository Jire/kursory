package org.jire.kursory.list.fixed.heap

import org.jire.kursory.IntCursor
import org.jire.kursory.list.IntList
import java.util.*

class FixedIntHeapList(capacity: Int) : AbstractFixedHeapList<IntCursor>(capacity), IntList {
	
	val values = IntArray(capacity)
	
	var nextIndex = 0
	
	override fun get(index: Int) = values[index]
	
	override fun set(index: Int, value: Int): Boolean {
		values[index] = value
		return true
	}
	
	override fun indexOf(value: Int): Int {
		TODO("Not yet implemented")
	}
	
	override fun canAdd(value: Int) = nextIndex < lastIndex
	
	override fun addUnsafe(value: Int) {
		values[nextIndex++] = value
	}
	
	override val cursor = FixedIntHeapListCursor(this)
	
	override fun clear() {
		Arrays.fill(values, nil)
	}
	
}