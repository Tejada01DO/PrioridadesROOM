package com.ucne.prioridades_room.di

import android.content.Context
import androidx.room.Room
import com.ucne.prioridades_room.data.local.PrioridadDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDbContext(@ApplicationContext context: Context): PrioridadDb {
        return Room.databaseBuilder(
            context,
            PrioridadDb::class.java,
            "prioridades_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun providePrioridadDao(appDbContext: PrioridadDb) = appDbContext.prioridadDao()
}