package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.OS
import org.jire.kursory.Cursor
import org.jire.kursory.list.fixed.AbstractFixedList

abstract class AbstractOffHeapFixedList<C : Cursor>(
	capacity: Int,
	val valueSize: Long
) : AbstractFixedList<C>(capacity), OffHeapFixedList<C> {
	
	fun pointer(index: Int) = address + (index * valueSize)
	
	val addressSpace = capacity * valueSize
	
	val address = OS.memory().allocate(addressSpace)
	
	open var nextIndex = 0
	open var highestIndex = 0
	
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