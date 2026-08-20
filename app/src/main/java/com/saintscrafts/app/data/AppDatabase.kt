package com.saintscrafts.app.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppDatabase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "saints_crafts.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE inventory (
                id TEXT PRIMARY KEY,
                name TEXT NOT NULL,
                quantity INTEGER NOT NULL,
                last_modified INTEGER NOT NULL
            )
        """)
        db.execSQL("""
            CREATE TABLE drawings (
                id TEXT PRIMARY KEY,
                title TEXT NOT NULL,
                path_data TEXT NOT NULL,
                last_modified INTEGER NOT NULL
            )
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Robust migration strategy placeholder for future schema upgrades
        db.execSQL("DROP TABLE IF EXISTS inventory")
        db.execSQL("DROP TABLE IF EXISTS drawings")
        onCreate(db)
    }
}
