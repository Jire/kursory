package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.fixed.AbstractFixedListCursor

abstract class AbstractFixedHeapListCursor(
	override val list: FixedHeapList<*>
) : AbstractFixedListCursor(list),
	FixedHeapListCursor