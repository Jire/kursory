package org.jire.kursory

object IntCollections : Collections {
	
	inline fun IntCollection.forEach(withEach: (Int) -> Unit) {
		for (value in values) {
			if (value != IntCollection.NIL) {
				withEach(value)
			}
		}
	}
	
}