package org.jire.kursory.util

import org.jire.kursory.util.Classes.getFieldOffset
import kotlin.reflect.KProperty

class IntCASDelegate<T : Any>(@Volatile private var value: Int = 0) : CASDelegate {
	
	private val valueOffset = getFieldOffset("value")
	
	operator fun getValue(thisRef: T, property: KProperty<*>) = value
	
	operator fun setValue(thisRef: T, property: KProperty<*>, value: Int) {
		while (Memory.compareAndSwapInt(thisRef, valueOffset, this.value, value)) {
			this.value = value
		}
	}
	
}