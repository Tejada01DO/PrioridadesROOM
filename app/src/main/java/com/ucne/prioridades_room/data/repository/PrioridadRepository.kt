package com.ucne.prioridades_room.data.repository

import com.ucne.prioridades_room.data.local.dao.PrioridadDao
import com.ucne.prioridades_room.data.local.entities.PrioridadEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrioridadRepository @Inject constructor(
    private val prioridadDao: PrioridadDao
){
    suspend fun savePrioridad(prioridad: PrioridadEntity){
        prioridadDao.Guardar(prioridad)
    }

    suspend fun getPrioridades(): Flow<List<PrioridadEntity>> {
        return prioridadDao.ObtenerTodos()
    }
}