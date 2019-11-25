package com.example.footballapps

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration


val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Create the new table
        database.execSQL("""
                CREATE TABLE new_Song (
                    id INTEGER PRIMARY KEY NOT NULL,
                    name TEXT,
                    tag TEXT NOT NULL DEFAULT ''
                )
                """.trimIndent())
    }
}