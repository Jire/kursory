package org.jire.kursory.list.fixed

import org.jire.kursory.Cursor
import org.jire.kursory.list.AbstractList

abstract class AbstractFixedList<C : Cursor>(
	override val capacity: Int,
	preferThreadSafety: Boolean = false
) : AbstractList<C>(preferThreadSafety),
	FixedList<C>