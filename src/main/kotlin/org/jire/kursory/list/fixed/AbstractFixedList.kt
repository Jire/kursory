package org.jire.kursory.list.fixed

import org.jire.kursory.Cursor

abstract class AbstractFixedList<C : Cursor>(override val capacity: Int) : FixedList<C>