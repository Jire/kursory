package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.AbstractListCursor

abstract class AbstractOffHeapFixedListCursor(
	override val list: OffHeapFixedList<*>
) : AbstractListCursor(list),
	OffHeapFixedListCursor