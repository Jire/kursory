package org.jire.kursory

abstract class AbstractOffHeapCollection<C : Cursor> : AbstractCollection<C>(), OffHeapCollection<C>