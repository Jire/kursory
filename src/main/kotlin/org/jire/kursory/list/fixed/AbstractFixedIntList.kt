package org.jire.kursory.list.fixed

abstract class AbstractFixedIntList<C : FixedListIntCursor>(capacity: Int) : AbstractFixedList<C>(capacity),
	FixedIntList<C>