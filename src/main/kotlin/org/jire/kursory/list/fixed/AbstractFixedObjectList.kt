package org.jire.kursory.list.fixed

import org.jire.kursory.list.ObjectList

abstract class AbstractFixedObjectList<T, C : FixedListObjectCursor<T>>(capacity: Int) : AbstractFixedList<C>(capacity),
	ObjectList<T, C>