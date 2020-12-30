package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.AbstractListCursor
import org.jire.kursory.list.List

abstract class AbstractFixedHeapListCursor(list: List<*>) : AbstractListCursor(list), FixedHeapListCursor