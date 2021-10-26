package com.example.routine_room.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RoutineDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(routineEntity: RoutineEntity)

    @Query("Select * From routine_table")
    fun getUser() : LiveData<List<RoutineEntity>>

    @Delete
    fun deleteRoutine(routineEntity: RoutineEntity)

    @Update
    fun updateRoutine(routineEntity: RoutineEntity)

}
