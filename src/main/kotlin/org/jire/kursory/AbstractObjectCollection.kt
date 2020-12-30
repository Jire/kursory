package org.jire.kursory

abstract class AbstractObjectCollection<T, C : ObjectCursor<T>> : AbstractCollection<C>(), ObjectCollection<T, C>