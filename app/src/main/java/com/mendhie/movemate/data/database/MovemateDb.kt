package com.mendhie.movemate.data.database

import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mendhie.movemate.data.models.SearchResult
import com.mendhie.movemate.data.models.Shipment
import com.mendhie.movemate.data.models.Utils.searchResults
import com.mendhie.movemate.data.models.Utils.shipments
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@androidx.room.Database(
    entities = [Shipment::class, SearchResult::class],
    version = 1,
    exportSchema = false
)
abstract class MovemateDb: RoomDatabase() {

    abstract fun shipmentDao(): ShipmentDao

    class DbCallback @Inject constructor(
        private val movemateDb: Provider<MovemateDb>,
        private val scope: CoroutineScope
    ): Callback(){
        private val TAG = "MovemateDatabase"

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d(TAG, "onCreate: db created - $db")

            scope.launch {
                movemateDb.get().shipmentDao().insertShipments(shipments = shipments)
                movemateDb.get().shipmentDao().insertSearchResults(results = searchResults)
            }

        }
    }
}