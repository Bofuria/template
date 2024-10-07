package com.empty.empty_project.presentation.t

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.empty.empty_project.db.TRepository
import com.empty.empty_project.db.tentities.TEntity
import com.empty.empty_project.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TViewModel @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    tRepository: TRepository
) : ViewModel() {

    private val _items = MutableStateFlow<List<TEntity>>(emptyList())
    val items = _items.asStateFlow()

    init {
        viewModelScope.launch(ioDispatcher) {
            tRepository.getAll().collect {
                _items.value = it
            }
        }
    }
}