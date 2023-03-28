package com.example.xcompanyassignment

import io.reactivex.Observable
import io.reactivex.Single

internal inline fun <T, P> Observable<List<T>>.mapList(
    crossinline transform: (T) -> P,
): Observable<List<P>> {
    return this.map { list -> list.map { transform(it) } }
}

internal inline fun <T, P> Single<List<T>>.mapList(
    crossinline transform: (T) -> P,
): Single<List<P>> {
    return this.map { list -> list.map { transform(it) } }
}

internal inline fun <T, P> List<T>.mapList(
    crossinline transform: (T) -> P,
): List<P> {
    return this.map { transform(it) }
}