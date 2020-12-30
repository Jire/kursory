package org.jire.kursory

object IntCursors : Cursors {
	
	inline fun IntCursor.forEach(crossinline withEach: (Int) -> Unit) = run {
		while (moveNext()) {
			withEach(next)
		}
	}
	
}