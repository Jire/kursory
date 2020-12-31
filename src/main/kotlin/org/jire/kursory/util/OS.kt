package org.jire.kursory.util

import org.jire.kursory.util.unsafe.UnsafeOS

interface OS {
	
	val mapAlignment: Long
	
	val pageSize: Int
	
	fun mapAlign(offset: Long): Long
	
	companion object : OS by UnsafeOS
	
}