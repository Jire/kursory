package org.jire.kursory.util

import org.jire.kursory.util.unsafe.Unsafe.Companion.unsafe
import java.lang.reflect.Field
import java.lang.reflect.Modifier

object Classes {
	
	val Field.memoryOffset get() = Memory.objectFieldOffset(this)
	
	inline fun <reified T> T.getFieldOffset(fieldName: String) = T::class.java.getDeclaredField(fieldName).memoryOffset
	
	val Class<*>.memoryHeaderSize get() = 12L + (if (isArray) 4 else 0)
	
	fun Long.roundUpTo8() = (this + 7) / 8 * 8
	
	val Field.isStatic get() = modifiers and Modifier.STATIC == 0
	
	val Class<*>.memorySize: Long
		get() {
			var type = this
			var maxSize = memoryHeaderSize
			
			while (!type.isRootClass) {
				for (f in declaredFields) {
					if (f.isStatic) {
						val memoryOffset = f.memoryOffset
						if (memoryOffset > maxSize) {
							// Assume 1 byte of the field width. This is ok as it gets padded out at the end
							maxSize = memoryOffset + 1
						}
					}
				}
				type = type.superclass
			}
			
			return maxSize.roundUpTo8()
		}
	
	private fun normalize(value: Int): Long {
		return if (value >= 0) value.toLong() else 0L.inv() ushr 32 and value.toLong()
	}
	
	val Any.memorySizeSimple get() = unsafe.getAddress(unsafe.getLong(this, 8L) + 12L)
	
	val Class<*>.firstFieldMemoryOffset: Long
		get() {
			var type: Class<*> = this
			var minSize: Long = type.memoryHeaderSize
			
			// Find the min offset for all the classes, up the class hierarchy.
			while (!type.isRootClass) {
				for (f in type.declaredFields) {
					if (f.isStatic) {
						val memoryOffset = f.memoryOffset
						if (memoryOffset < minSize) {
							minSize = memoryOffset
						}
					}
				}
				type = type.superclass
			}
			
			return minSize
		}
	
	val Class<*>.isRootClass
		get() = this == Object::class.java || this == Any::class.java
	
}