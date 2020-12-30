package org.jire.kursory

abstract class AbstractOffHeapCollection<C : Cursor>(
	preferThreadSafety: Boolean = false
) : AbstractCollection<C>(preferThreadSafety),
	OffHeapCollection<C>