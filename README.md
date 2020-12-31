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

## Benchmarks

`ObjectArrayListBench` and `IntArrayListBench` are Java's default `ArrayList`.

```
Benchmark                          Mode  Cnt           Score           Error  Units
IntArrayListBench.add             thrpt    5    27216759.704 ± 164175288.726  ops/s
IntArrayListBench.get             thrpt    5   180236099.358 ±  23241708.466  ops/s
IntArrayListBench.iterate         thrpt    5       35537.573 ±       636.187  ops/s
IntArrayListBench.set             thrpt    5   264129989.872 ± 169490821.957  ops/s
IntOffHeapFixedListBench.add      thrpt    5   667186299.563 ±  48891692.913  ops/s
IntOffHeapFixedListBench.get      thrpt    5   227710090.666 ±  24097689.141  ops/s
IntOffHeapFixedListBench.iterate  thrpt    5   765847462.173 ±  35963252.920  ops/s
IntOffHeapFixedListBench.set      thrpt    5   641064559.613 ±  26833271.922  ops/s
ObjectArrayListBench.add          thrpt    5   123065044.766 ± 124875478.424  ops/s
ObjectArrayListBench.get          thrpt    5   228406101.553 ±  38913673.579  ops/s
ObjectArrayListBench.iterate      thrpt    5       35178.961 ±       692.201  ops/s
ObjectArrayListBench.set          thrpt    5   908395445.681 ±  39278778.898  ops/s
ObjectOffHeapFixedListBench.add   thrpt    5  1816560008.094 ± 105762407.175  ops/s
ObjectOffHeapFixedListBench.get   thrpt    5   146546726.728 ±  15365359.110  ops/s
ObjectOffHeapFixedListBench.set   thrpt    5   224969678.559 ±  39013268.352  ops/s
```