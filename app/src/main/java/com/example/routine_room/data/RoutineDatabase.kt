package com.example.routine_room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoutineEntity::class], version = 1 )
abstract class RoutineDatabase : RoomDatabase() {

    abstract fun getRoutineDao() : RoutineDAO

    companion object{
        private var INSTANCE : RoutineDatabase? = null

        fun getRoutineDatabase(context: Context) : RoutineDatabase {
            if(INSTANCE != null){

                return INSTANCE!!

            }else{
                val builder =Room.databaseBuilder(
                    context.applicationContext,
                    RoutineDatabase::class.java,
                    "routinedb")

                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()


            }
            return INSTANCE!!
            }
        }
    }
