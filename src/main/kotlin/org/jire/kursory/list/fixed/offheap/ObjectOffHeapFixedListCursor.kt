/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.fixed.FixedListObjectCursor

class ObjectOffHeapFixedListCursor<T : Any>(
	override val list: ObjectOffHeapFixedList<T>
) : AbstractOffHeapFixedListCursor(list),
	FixedListObjectCursor<T> {
	
	override val next get() = list[index]
	
}