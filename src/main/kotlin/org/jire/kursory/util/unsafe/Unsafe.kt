package org.jire.kursory.util.unsafe

import sun.misc.Unsafe as SunUnsafe

interface Unsafe {
	
	companion object : Unsafe {
		
		@JvmStatic
		val unsafe = SunUnsafe::class.java.getDeclaredField("theUnsafe").run {
			isAccessible = true
			get(null) as SunUnsafe
		}
		
		const val COPY_STRIDE = 8L
		
	}
	
}