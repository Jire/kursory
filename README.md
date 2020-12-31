# Kursory

_high-performance collections for the JVM_

[![Build Status](https://travis-ci.com/Jire/kursory.svg?branch=master)](https://travis-ci.com/Jire/kursory)
[![license](https://img.shields.io/github/license/Jire/kursory.svg)](https://github.com/Jire/kursory/blob/master/LICENSE.txt)

**WARNING:** This project is still under initial development and is not ready to be used.

## Goals

* Offer the highest performance specialized collections of their class on the JVM, period.
* Beyond instantiation, maintain absolutely zero heap allocations when `OffHeapCollection`s are used.
* Deterministic reference-counted resource releasing for `OffHeapCollection`
* `OnHeapCollection` versions, mainly for benchmark baseline.

## Collection Hierarchy

Every collection fits under a strict, type-safe hierarchy.

You can determine a suitable collection by:

```
1{AccessoryModifier}2{TypeModifier}3{Type}
```

For example `PersistedIntOffHeapFixedList`:

```
1{Persisted}2{Int}3{OffHeapFixedList}
```

**Collection hierarchy:**

* Collection
    * List
        * FixedList
            * OnHeapFixedList
            * OffHeapFixedList
        * ElasticList
            * OnHeapElasticList
            * OffHeapElasticList
    * Map
        * HashMap
            * OnHeapHashMap
            * OffHeapHashMap

**Collection type modifiers:**

* List
    * Object
    * Int
* Map
    * ObjectObject
    * IntInt

**Collection accessory modifiers:**

* ThreadSafe _(implements thread-safety by read/write)_
* Persisted _(persists to disk)_