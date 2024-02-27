package com.ucne.prioridades_room.ui.prioridades

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.prioridades_room.data.local.entities.PrioridadEntity
import com.ucne.prioridades_room.data.repository.PrioridadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrioridadViewModel @Inject constructor(
    private val prioridadRepository: PrioridadRepository
) : ViewModel() {
    private val _state = MutableStateFlow(PrioridadState())
    val state = _state.asStateFlow()

    fun Guardar() {
        viewModelScope.launch {
            prioridadRepository.savePrioridad(_state.value.prioridad)
        }
    }

    fun onEvent(event: PrioridadEvent) {
        when (event) {
            is PrioridadEvent.NombreChanged -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(nombre = event.nombre)
                    )
                }
            }

            is PrioridadEvent.DescripcionChanged -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(descripcion = event.descripcion)
                    )
                }
            }

            is PrioridadEvent.PlazoChanged -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(plazo = event.plazo.toIntOrNull() ?: 0)
                    )
                }
            }

            PrioridadEvent.onSave -> {
                Guardar()
                onEvent(PrioridadEvent.onLimpiar)
            }

            PrioridadEvent.onLimpiar -> {
                _state.update {
                    it.copy(
                        prioridad = PrioridadEntity(),
                        successMessage = null,
                        error = null,
                        isLoading = false
                    )
                }
            }

        }
    }
}

data class PrioridadState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null,
    val prioridad: PrioridadEntity = PrioridadEntity()
)

sealed class PrioridadEvent {
    data class NombreChanged(val nombre: String) : PrioridadEvent()
    data class DescripcionChanged(val descripcion: String) : PrioridadEvent()
    data class PlazoChanged(val plazo: String) : PrioridadEvent()
    object onSave : PrioridadEvent()
    object onLimpiar : PrioridadEvent()
}