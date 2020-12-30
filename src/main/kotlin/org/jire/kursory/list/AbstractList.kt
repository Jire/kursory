package org.jire.kursory.list

import org.jire.kursory.AbstractCollection

abstract class AbstractList<C : ListCursor>(
) : AbstractCollection<C>(),
	List<C>