package org.jire.kursory.list.fixed

import org.jire.kursory.IntCursor
import org.jire.kursory.list.IntList

abstract class FixedIntList(capacity: Int) : AbstractFixedList<IntCursor>(capacity), IntList