package com.palash.paging3.api_service

import com.palash.paging3.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnauthAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page :Int) : QuoteList
}