package org.jire.kursory

object ObjectCursors : Cursors {
	
	inline fun <T> ObjectCursor<T>.forEach(crossinline withEach: (T) -> Unit) = run {
		while (moveNext()) {
			withEach(next)
		}
	}
	
}