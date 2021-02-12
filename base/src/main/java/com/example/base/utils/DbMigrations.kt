package com.example.base.utils

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_130_2: Migration = object : Migration(129, 130) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS products_new (id INTEGER PRIMARY KEY NOT NULL, name TEXT DEFAULT '', cost TEXT DEFAULT '',  description TEXT DEFAULT '', image TEXT DEFAULT '' )")
        database.execSQL("INSERT INTO products_new (id, name, cost, description, image) SELECT id FROM id, name, cost, description, image")
    }
}
