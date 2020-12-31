/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list.fixed.heap

import org.jire.kursory.list.fixed.FixedListObjectCursor

class ObjectHeapFixedListCursor<T : Any>(
	override val list: ObjectHeapFixedList<T>
) : AbstractHeapFixedListCursor(list), FixedListObjectCursor<T> {
	
	override val next get() = list[index]!!
	
}