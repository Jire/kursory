package org.jire.kursory.list.fixed.offheap

abstract class AbstractThreadSafeOffHeapFixedList<C : OffHeapFixedListCursor>(
	capacity: Int,
	valueSize: Long
) : AbstractOffHeapFixedList<C>(capacity, valueSize)