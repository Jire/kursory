package org.jire.kursory.util

import org.jire.kursory.util.unsafe.UnsafeFences

interface Fences {
	
	fun load()
	
	companion object : Fences by UnsafeFences
	
}