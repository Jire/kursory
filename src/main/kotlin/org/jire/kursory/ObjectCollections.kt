package org.jire.kursory

object ObjectCollections : Collections {
	
	inline fun <T> ObjectCollection<T>.forEach(crossinline withEach: (T) -> Unit) = ObjectCursors.run {
		cursor.forEach(withEach)
	}
	
}