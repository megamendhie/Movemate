package com.mendhie.movemate.data.di

import android.app.Application
import androidx.room.Room
import com.mendhie.movemate.data.database.MovemateDb
import com.mendhie.movemate.data.database.ShipmentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(app: Application, callback: MovemateDb.DbCallback): MovemateDb {
        return Room.databaseBuilder(app, MovemateDb::class.java, "movemate.db")
            .addCallback(callback)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesMoviesDao(db: MovemateDb): ShipmentDao {
        return db.shipmentDao()
    }

    @Singleton
    @Provides
    fun providesCoroutineScope() = CoroutineScope(SupervisorJob())
}