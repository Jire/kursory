package org.jire.kursory

object IntCollections : Collections {
	
	inline fun IntCollection.forEach(crossinline withEach: (Int) -> Unit) = IntCursors.run {
		cursor.forEach(withEach)
	}
	
}