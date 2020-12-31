/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list

object ListObjectCursors {
	
	inline fun <T, C : ListObjectCursor<T>> C.forEach(crossinline withEach: (T) -> Unit) = run {
		while (moveNext()) {
			withEach(next)
		}
	}
	
}