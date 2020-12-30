package org.jire.kursory.list

import org.jire.kursory.ObjectCollections

object ObjectLists : ObjectCollections {
	
	inline fun <T, C : ListObjectCursor<T>> ObjectList<T, C>.forEach(crossinline withEach: (T) -> Unit) =
		ListObjectCursors.run {
			cursor.forEach(withEach)
		}
	
}