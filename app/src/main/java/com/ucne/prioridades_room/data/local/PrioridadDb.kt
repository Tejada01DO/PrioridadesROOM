package com.ucne.prioridades_room.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucne.prioridades_room.data.local.dao.PrioridadDao
import com.ucne.prioridades_room.data.local.entities.PrioridadEntity

@Database(entities = [PrioridadEntity::class], version = 1, exportSchema = false)
abstract class PrioridadDb: RoomDatabase() {
    abstract fun prioridadDao(): PrioridadDao
}