package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.fixed.AbstractFixedListCursor

abstract class AbstractHeapFixedListCursor(
	override val list: HeapFixedList<*>
) : AbstractFixedListCursor(list),
	HeapFixedListCursor