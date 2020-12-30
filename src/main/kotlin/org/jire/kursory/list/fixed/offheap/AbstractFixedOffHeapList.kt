package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.OS
import org.jire.kursory.Cursor
import org.jire.kursory.list.fixed.AbstractFixedList

abstract class AbstractFixedOffHeapList<C : Cursor>(
	capacity: Int,
	preferThreadSafety: Boolean = false,
	val valueSize: Long
) : AbstractFixedList<C>(capacity), FixedOffHeapList<C> {
	
	fun pointer(index: Int) = address + (index * valueSize)
	
	val addressSpace = capacity * valueSize
	
	val address = OS.memory().allocate(addressSpace)
	
	var nextIndex = 0
	var highestIndex = 0
	
	override fun clear() = OS.memory().setMemory(address, addressSpace, 0)
	
	override fun retain(): Int {
		TODO("Not yet implemented")
	}
	
	override fun release(): Boolean {
		TODO("Not yet implemented")
	}
	
	init {
		@Suppress("LeakingThis")
		clear()
	}
	
}