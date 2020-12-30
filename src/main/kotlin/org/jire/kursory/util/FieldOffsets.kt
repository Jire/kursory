package org.jire.kursory.util

import net.openhft.chronicle.core.OS
import java.lang.reflect.Field

object FieldOffsets {
	
	fun <T : Any> T.getFieldOffset(field: Field) = OS.memory().getFieldOffset(field)
	
	fun <T : Any> T.getFieldOffset(fieldName: String) = getFieldOffset(javaClass.getDeclaredField(fieldName))
	
}