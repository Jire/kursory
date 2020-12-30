package org.jire.kursory.list

import org.jire.kursory.Collection

interface List : Collection {
	
	fun removeAt(index: Int): Boolean
	
}