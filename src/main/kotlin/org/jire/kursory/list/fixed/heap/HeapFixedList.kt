package org.jire.kursory.list.fixed.heap

import org.jire.kursory.Cursor
import org.jire.kursory.HeapCollection
import org.jire.kursory.list.fixed.FixedList

interface HeapFixedList<C : Cursor> : FixedList<C>, HeapCollection<C>