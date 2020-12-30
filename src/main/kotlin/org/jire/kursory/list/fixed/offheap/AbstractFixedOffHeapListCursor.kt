package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.AbstractListCursor
import org.jire.kursory.list.List

abstract class AbstractFixedOffHeapListCursor(list: List<*>) : AbstractListCursor(list), FixedOffHeapListCursor