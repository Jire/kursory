package org.jire.kursory

abstract class AbstractHeapCollection<C : Cursor>(
	preferThreadSafety: Boolean = false
) : AbstractCollection<C>(preferThreadSafety),
	HeapCollection<C>