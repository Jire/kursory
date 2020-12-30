package org.jire.kursory.list

import org.jire.kursory.AbstractCollection
import org.jire.kursory.Cursor

abstract class AbstractList<C : Cursor>(
	preferThreadSafety: Boolean = false
) : AbstractCollection<C>(preferThreadSafety),
	List<C>