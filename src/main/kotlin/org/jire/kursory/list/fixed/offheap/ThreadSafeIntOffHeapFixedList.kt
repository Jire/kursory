/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory.list.fixed.offheap

import org.jire.kursory.list.List
import org.jire.kursory.list.fixed.FixedIntList
import org.jire.kursory.util.IntCASDelegate
import org.jire.kursory.util.Memory

open class ThreadSafeIntOffHeapFixedList(capacity: Int) :
	AbstractThreadSafeOffHeapFixedList<ThreadSafeIntOffHeapFixedListCursor>(capacity, Int.SIZE_BYTES.toLong()),
	FixedIntList<ThreadSafeIntOffHeapFixedListCursor> {
	
	override var nextIndex by IntCASDelegate()
	override var highestIndex by IntCASDelegate()
	
	@Suppress("LeakingThis")
	override val cursor = ThreadSafeIntOffHeapFixedListCursor(this)
	
	override fun get(index: Int) = Memory.getIntVolatile(pointer(index))
	
	override fun set(index: Int, value: Int): Boolean {
		if (index > highestIndex) highestIndex = index
		Memory.putIntVolatile(pointer(index), value)
		return true
	}
	
	override fun indexOf(value: Int): Int {
		for (index in 0..highestIndex) {
			if (value == get(index)) {
				return index
			}
		}
		return List.INVALID_INDEX
	}
	
	override fun canAdd(value: Int) = nextIndex < lastIndex
	
	override fun addNoCheck(value: Int) {
		set(nextIndex++, value)
	}
	
}