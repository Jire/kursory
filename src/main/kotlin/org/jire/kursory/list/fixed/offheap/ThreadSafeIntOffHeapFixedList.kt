package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.OS
import org.jire.kursory.list.List
import org.jire.kursory.list.fixed.FixedIntList

open class ThreadSafeIntOffHeapFixedList(capacity: Int) :
	AbstractThreadSafeOffHeapFixedList<ThreadSafeIntOffHeapFixedListCursor>(capacity, Int.SIZE_BYTES.toLong()),
	FixedIntList<ThreadSafeIntOffHeapFixedListCursor> {
	
	@Suppress("LeakingThis")
	override val cursor = ThreadSafeIntOffHeapFixedListCursor(this)
	
	override fun get(index: Int) = OS.memory().readVolatileInt(pointer(index))
	
	override fun set(index: Int, value: Int): Boolean {
		if (index > highestIndex) highestIndex = index
		OS.memory().writeVolatileInt(pointer(index), value)
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