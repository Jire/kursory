package org.jire.kursory.list

import org.jire.kursory.IntCollections

object IntLists : IntCollections {
	
	inline fun <C : ListIntCursor> IntList<C>.forEach(crossinline withEach: (Int) -> Unit) = ListIntCursors.run {
		cursor.forEach(withEach)
	}
	
}