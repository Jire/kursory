/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list

import org.jire.kursory.Collection

interface List<C : ListCursor> : Collection<C> {
	
	companion object {
		const val INVALID_INDEX = -1
	}
	
	fun removeAt(index: Int): Boolean
	
}