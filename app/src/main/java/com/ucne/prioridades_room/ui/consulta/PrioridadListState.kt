package com.ucne.prioridades_room.ui.consulta

import com.ucne.prioridades_room.data.local.entities.PrioridadEntity

data class PrioridadListState(
    val isLoading: Boolean = false,
    val prioridades: List<PrioridadEntity>? = emptyList(),
    val error: String? = null,
    val prioridad: PrioridadEntity? = PrioridadEntity(
        0,
        "",
        "",
        0,
        false,

    ),
    val selectedPrioridades: PrioridadEntity? = null
)