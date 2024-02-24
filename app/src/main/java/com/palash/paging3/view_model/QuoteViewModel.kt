package com.palash.paging3.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.palash.paging3.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val quoteRepository: QuoteRepository) : ViewModel() {

    val list = quoteRepository.getQuotes().cachedIn(viewModelScope)
}