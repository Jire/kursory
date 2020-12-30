package org.jire.kursory.list

object ListObjectCursors {
	
	inline fun <T, C : ListObjectCursor<T>> C.forEach(crossinline withEach: (T) -> Unit) = run {
		while (moveNext()) {
			withEach(next)
		}
	}
	
}