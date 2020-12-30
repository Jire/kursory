package org.jire.kursory.list

abstract class AbstractListCursor(override val list: List<*>) : ListCursor {
	
	override var index = -1
	
}