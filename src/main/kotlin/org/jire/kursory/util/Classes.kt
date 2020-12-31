package org.jire.kursory.util

object Classes {
	
	val Class<*>.isRootClass
		get() = this == Object::class.java || this == Any::class.java
	
}