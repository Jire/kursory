package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.OffHeapCollection
import org.jire.kursory.list.fixed.FixedList

interface OffHeapFixedList<C : OffHeapFixedListCursor> : FixedList<C>, OffHeapCollection<C>