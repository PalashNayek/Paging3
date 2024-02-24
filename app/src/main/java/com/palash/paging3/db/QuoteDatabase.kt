package com.palash.paging3.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.palash.paging3.models.QuoteRemoteKeys
import com.palash.paging3.models.Result

@Database(entities = [Result::class, QuoteRemoteKeys::class ], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao() : QuoteDao
    abstract fun remoteKeyDao() : RemoteKeysDao
}