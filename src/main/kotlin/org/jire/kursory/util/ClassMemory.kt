package org.jire.kursory.util

import org.jire.kursory.util.Classes.isRootClass
import org.jire.kursory.util.Fields.isStatic
import org.jire.kursory.util.Fields.memoryOffset
import org.jire.kursory.util.Maths.roundUpTo8

class ClassMemory<T>(val type: Class<T>) {
	
	val headerSize = 12L + (if (type.isArray) 4 else 0)
	
	val size by lazy(LazyThreadSafetyMode.NONE) {
		var type: Class<*> = type
		var maxSize = headerSize
		
		while (!type.isRootClass) {
			for (f in type.declaredFields) {
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
		
		maxSize.roundUpTo8()
	}
	
	val firstFieldMemoryOffset by lazy(LazyThreadSafetyMode.NONE) {
		var type: Class<*> = type
		var minSize = headerSize
		
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
		
		minSize
	}
	
}