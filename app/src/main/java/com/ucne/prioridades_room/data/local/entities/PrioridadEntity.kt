package com.ucne.prioridades_room.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("prioridades")
data class PrioridadEntity(
    @PrimaryKey(autoGenerate = true)
    val prioridadId : Int = 0,
    val nombre: String = "",
    val descripcion: String = "",
    val plazo: Int = 0,
    val esNulo: Boolean = false,
)