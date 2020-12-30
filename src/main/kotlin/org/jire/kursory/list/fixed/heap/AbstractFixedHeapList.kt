package org.jire.kursory.list.fixed.heap

import org.jire.kursory.Cursor
import org.jire.kursory.list.fixed.AbstractFixedList

abstract class AbstractFixedHeapList<C : Cursor>(capacity: Int) : AbstractFixedList<C>(capacity), FixedHeapList<C>