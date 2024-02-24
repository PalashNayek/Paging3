package com.palash.paging3.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.palash.paging3.api_service.UnauthAPI
import com.palash.paging3.db.QuoteDatabase
import com.palash.paging3.paging.QuotePagingSource
import com.palash.paging3.paging.QuoteRemoteMediator
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val unauthAPI: UnauthAPI,
                                          private val quoteDatabase: QuoteDatabase)  {

    @OptIn(ExperimentalPagingApi::class)
    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        remoteMediator = QuoteRemoteMediator(unauthAPI, quoteDatabase),
        pagingSourceFactory = { quoteDatabase.quoteDao().getQuotes() }
    ).liveData
}