/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.fixed.AbstractFixedList
import org.jire.kursory.util.Memory

abstract class AbstractOffHeapFixedList<C : OffHeapFixedListCursor>(
	capacity: Int,
	val valueSize: Long
) : AbstractFixedList<C>(capacity), OffHeapFixedList<C> {
	
	fun pointer(index: Int) = address + (index * valueSize)
	
	val addressSpace = capacity * valueSize
	
	open val address = Memory.allocate(addressSpace)
	
	@Volatile
	open var nextIndex: Int = 0
	
	@Volatile
	open var highestIndex: Int = 0
	
	override fun clear() = Memory.set(address, addressSpace, 0)
	
	override fun initialize() = clear()
	
	override fun free() = Memory.free(address)
	
	init {
		@Suppress("LeakingThis")
		initialize()
	}
	
}