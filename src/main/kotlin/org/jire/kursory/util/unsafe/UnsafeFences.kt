package org.jire.kursory.util.unsafe

import org.jire.kursory.util.Fences
import org.jire.kursory.util.unsafe.Unsafe.Companion.unsafe

object UnsafeFences : Fences {
	
	override fun load() = unsafe.loadFence()
	
}