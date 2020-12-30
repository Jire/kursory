package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.Cursor
import org.jire.kursory.OffHeapCollection
import org.jire.kursory.list.fixed.FixedList

interface FixedOffHeapList<C : Cursor> : FixedList<C>, OffHeapCollection<C>