package com.example.roomdatabase.model.local

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.roomdatabase.model.entity.User


private  const val DATABASE_NAME = "user_database"         //34an lw 7bet ast5dmo b3d kda

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO() : UserDAO


    companion object {
        @Volatile                 // mt4afa mn kol al threads f ay 7d hyndhha hy2dr yst5dmha
        private var instance:UserDatabase? = null

        fun getInstance(context:Context):UserDatabase{
            return  instance?: synchronized(Any()){
                instance?: buildDatabase(context).also{instance = it}
            }
        }

        private fun buildDatabase(context: Context): UserDatabase {
            return  Room.databaseBuilder(context.applicationContext,
                UserDatabase::class.java, DATABASE_NAME
            ).build()
        }


    }

}