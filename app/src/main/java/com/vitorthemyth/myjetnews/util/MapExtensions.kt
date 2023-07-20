package com.vitorthemyth.myjetnews.util

internal fun <E> Set<E>.addOrRemove(element: E): Set<E> {
    return this.toMutableSet().apply {
        if (!add(element)) {
            remove(element)
        }
    }.toSet()
}
