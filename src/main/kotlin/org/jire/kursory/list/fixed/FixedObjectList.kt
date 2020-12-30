package org.jire.kursory.list.fixed

import org.jire.kursory.list.ObjectList

interface FixedObjectList<T, C : FixedListObjectCursor<T>> : FixedList<C>, ObjectList<T, C>