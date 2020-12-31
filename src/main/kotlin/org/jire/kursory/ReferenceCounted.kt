package org.jire.kursory

interface ReferenceCounted {
	
	fun release() = false
	
	fun retain() = 0
	
}