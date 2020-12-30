package org.jire.kursory.list

import org.jire.kursory.IntCursor

interface ListIntCursor : ListCursor, IntCursor {
	
	val next: Int
	
}