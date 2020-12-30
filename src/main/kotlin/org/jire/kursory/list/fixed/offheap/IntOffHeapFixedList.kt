package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.OS
import org.jire.kursory.IntCursor
import org.jire.kursory.list.IntList
import org.jire.kursory.list.List

class IntOffHeapFixedList(
	capacity: Int,
) : AbstractOffHeapFixedList<IntCursor>(capacity, Int.SIZE_BYTES.toLong()), IntList {
	
	override val cursor = IntOffHeapFixedListCursor(this)
	
	override fun get(index: Int) = OS.memory().readInt(pointer(index))
	
	override fun set(index: Int, value: Int): Boolean {
		if (index > highestIndex) highestIndex = index
		OS.memory().writeInt(pointer(index), value)
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
	
	override fun addUnsafe(value: Int) {
		set(nextIndex++, value)
	}
	
}