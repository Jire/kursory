/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.jire.kursory

import java.io.File
import kotlin.concurrent.thread

interface OffHeapCollection<C : Cursor> : Collection<C>, ReferenceCounted {
	
	val persistTo: File? get() = null
	
	fun initialize()
	
	fun free() = clear()
	
	fun freeOnExit() = Runtime.getRuntime().addShutdownHook(thread(false) { free() })
	
}