package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.List
import org.jire.kursory.list.fixed.FixedIntList
import org.jire.kursory.util.Memory

class IntOffHeapFixedList(
	capacity: Int,
) : AbstractOffHeapFixedList<IntOffHeapFixedListCursor>(capacity, Int.SIZE_BYTES.toLong()),
	FixedIntList<IntOffHeapFixedListCursor> {
	
	override val cursor = IntOffHeapFixedListCursor(this)
	
	override fun get(index: Int) = Memory.getInt(pointer(index))
	
	override fun set(index: Int, value: Int): Boolean {
		if (index > highestIndex) highestIndex = index
		Memory.putInt(pointer(index), value)
		return true
	}
	
	override fun indexOf(value: Int): Int {
		for (index in 0..highestIndex) {
			if (value == get(index)) {
				return index
			}
		}
		return List.INVALID_INDEX
	}
	
	override fun canAdd(value: Int) = nextIndex < lastIndex
	
	override fun addNoCheck(value: Int) {
		set(nextIndex++, value)
	}
	
}