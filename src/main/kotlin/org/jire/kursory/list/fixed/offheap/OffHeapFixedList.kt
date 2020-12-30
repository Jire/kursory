package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.OffHeapCollection
import org.jire.kursory.list.fixed.FixedList
import org.jire.kursory.list.fixed.FixedListCursor

interface OffHeapFixedList<C : FixedListCursor> : FixedList<C>, OffHeapCollection<C>