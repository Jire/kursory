package org.jire.kursory.list

import org.jire.kursory.IntCursors

object ListIntCursors : IntCursors {
	
	inline fun <C : ListIntCursor> C.forEach(crossinline withEach: (Int) -> Unit) = run {
		while (moveNext()) {
			withEach(next)
		}
	}
	
}