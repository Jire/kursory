/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list.fixed

import org.jire.kursory.list.List

interface FixedList<C : FixedListCursor> : List<C> {
	
	val capacity: Int
	
	val lastIndex: Int get() = capacity - 1
	
	override val size get() = capacity
	
}