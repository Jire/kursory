/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list

import org.jire.kursory.ObjectCollections

object ObjectLists : ObjectCollections {
	
	inline fun <T, C : ListObjectCursor<T>> ObjectList<T, C>.forEach(crossinline withEach: (T) -> Unit) =
		ListObjectCursors.run {
			cursor.forEach(withEach)
		}
	
}