package org.jire.kursory.util

import net.openhft.chronicle.core.OS
import org.jire.kursory.util.FieldOffsets.getFieldOffset
import kotlin.reflect.KProperty

class IntCASDelegate<T : Any>(@Volatile private var value: Int = 0) : CASDelegate {
	
	private val valueOffset = getFieldOffset("value")
	
	operator fun getValue(thisRef: T, property: KProperty<*>) = value
	
	operator fun setValue(thisRef: T, property: KProperty<*>, value: Int) {
		while (OS.memory().compareAndSwapInt(thisRef, valueOffset, this.value, value)) {
			this.value = value
		}
	}
	
}