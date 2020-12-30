package org.jire.kursory

abstract class AbstractCollection<C : Cursor>(
	override val preferThreadSafety: Boolean = false
) : Collection<C>