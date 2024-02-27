package com.ucne.prioridades_room.ui.consulta

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.prioridades_room.data.repository.PrioridadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class C_Prioridades_ViewModel @Inject constructor(
    private val prioridadRepository: PrioridadRepository

) : ViewModel() {

    private val _state = MutableStateFlow(PrioridadListState())
    val state = _state.asStateFlow()

    init {
        getPrioridades()
    }

    private fun getPrioridades() {
        viewModelScope.launch {
            prioridadRepository.getPrioridades()
        }
    }
}