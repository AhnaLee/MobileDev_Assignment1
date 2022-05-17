package com.codinginflow.simplecachingexample.util

import kotlinx.coroutines.flow.*

//video 4 22:00

inline fun <ResultType, RequestType> networkBoundResources (
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    val data = query().first() //one list of restaurant from the database

    val flow = if (shouldFetch(data)) { //check if it's time to update cache if the data is stay or not
        emit(Resource.Loading(data)) //video 4 35:00

        try{
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        }catch (throwable: Throwable) {
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}