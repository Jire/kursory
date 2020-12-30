package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.fixed.AbstractFixedList
import org.jire.kursory.list.fixed.FixedListCursor

abstract class AbstractHeapFixedList<C : FixedListCursor>(capacity: Int) : AbstractFixedList<C>(capacity),
	HeapFixedList<C>