package org.jire.kursory.list

import org.jire.kursory.ObjectCursor

interface ListObjectCursor<T> : ListCursor, ObjectCursor<T> {
	
	val next: T
	
}