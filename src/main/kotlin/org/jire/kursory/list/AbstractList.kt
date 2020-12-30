package org.jire.kursory.list

import org.jire.kursory.AbstractCollection
import org.jire.kursory.Cursor

abstract class AbstractList<C : Cursor>(
) : AbstractCollection<C>(),
	List<C>