package org.jire.kursory.util

import java.lang.reflect.Field
import java.lang.reflect.Modifier

object Fields {
	
	val Field.isStatic get() = modifiers and Modifier.STATIC == 0
	
	val Field.memoryOffset get() = Memory.objectFieldOffset(this)
	
	inline fun <reified T> T.getFieldOffset(fieldName: String) = T::class.java.getDeclaredField(fieldName).memoryOffset
	
}