package org.jire.kursory.list.fixed.offheap

import net.openhft.chronicle.core.Jvm
import org.jire.kursory.list.fixed.FixedObjectList
import org.jire.kursory.util.Classes.memorySize
import org.jire.kursory.util.Memory

class ObjectOffHeapFixedList<T : Any>(
	capacity: Int,
	val flyweight: T,
	val type: Class<T> = flyweight.javaClass,
) : AbstractOffHeapFixedList<ObjectOffHeapFixedListCursor<T>>(capacity, type.memorySize),
	FixedObjectList<T, ObjectOffHeapFixedListCursor<T>> {
	
	override fun get(index: Int) = flyweight.apply {
		Memory.copy(pointer(index), this, valueSize)
	}
	
	override fun set(index: Int, value: T?): Boolean {
		value!!
		
		if (Jvm.isJava9Plus()) {
			Memory.copy(value, pointer(index), valueSize)
		} else {
			Memory.copy(value, 0, null, pointer(index), valueSize)
		}
		
		return true
	}
	
	override fun indexOf(value: T?): Int {
		TODO("Not yet implemented")
	}
	
	override fun canAdd(value: T?) = nextIndex < lastIndex
	
	override fun addNoCheck(value: T?) {
		set(nextIndex++, value)
	}
	
	override val cursor = ObjectOffHeapFixedListCursor(this)
	
	override fun initialize() {}
	
}