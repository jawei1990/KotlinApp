package com.example.lab13

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper (context: Context, name: String = database,
                  factory:SQLiteDatabase.CursorFactory ?= null, version : Int = v):
SQLiteOpenHelper(context, name, factory, version) //
{
    companion object
    {
        private const val database = "ktLab13.db" // database name
        private const val  v = 1                  // data version
    }

    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL("CREATE TABLE MY_TABLE(book text PRIMARY KEY, price integer NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        // Remove table if exists
        db?.execSQL("DROP TABLE IF EXISTS MY_TABLE")

        // Recreate table
        onCreate(db)
    }


}

