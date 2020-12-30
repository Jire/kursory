package org.jire.kursory.list.fixed

import org.jire.kursory.list.AbstractListCursor

abstract class AbstractFixedListCursor(override val list: FixedList<*>) : AbstractListCursor(list)