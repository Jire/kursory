package org.jire.kursory.list.fixed

import org.jire.kursory.list.AbstractList

abstract class AbstractFixedList<C : FixedListCursor>(
	override val capacity: Int,
) : AbstractList<C>(),
	FixedList<C>