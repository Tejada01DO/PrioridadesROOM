package com.ucne.prioridades_room.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.ucne.prioridades_room.data.local.entities.PrioridadEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrioridadDao {
    @Upsert
    suspend fun Guardar(prioridad: PrioridadEntity)

    @Query("SELECT * FROM prioridades WHERE prioridadId=:id Limit 1")
    suspend fun ObtenerPorId(id: Int): PrioridadEntity?

    @Delete
    suspend fun Eliminar(prioridad: PrioridadEntity)

    @Query("Select * From prioridades")
    fun ObtenerTodos(): Flow<List<PrioridadEntity>>
}