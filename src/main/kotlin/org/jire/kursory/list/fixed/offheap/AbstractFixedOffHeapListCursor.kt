package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.AbstractListCursor

abstract class AbstractFixedOffHeapListCursor(
	override val list: FixedOffHeapList<*>
) : AbstractListCursor(list),
	FixedOffHeapListCursor