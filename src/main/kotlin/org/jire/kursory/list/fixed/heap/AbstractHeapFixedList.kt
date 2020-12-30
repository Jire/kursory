package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.fixed.AbstractFixedList

abstract class AbstractHeapFixedList<C : HeapFixedListCursor>(capacity: Int) : AbstractFixedList<C>(capacity),
	HeapFixedList<C>