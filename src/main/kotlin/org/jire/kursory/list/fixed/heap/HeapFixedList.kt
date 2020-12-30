package org.jire.kursory.list.fixed.heap

import org.jire.kursory.HeapCollection
import org.jire.kursory.list.fixed.FixedList
import org.jire.kursory.list.fixed.FixedListCursor

interface HeapFixedList<C : FixedListCursor> : FixedList<C>, HeapCollection<C>