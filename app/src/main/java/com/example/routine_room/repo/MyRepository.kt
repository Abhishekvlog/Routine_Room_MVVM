package com.example.routine_room.repo

import androidx.lifecycle.LiveData
import com.example.routine_room.data.RoutineDAO
import com.example.routine_room.data.RoutineEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(val routineDAO: RoutineDAO) {

    fun createUser(routineEntity: RoutineEntity){
        CoroutineScope(Dispatchers.IO).launch {
            routineDAO.register(routineEntity)
        }
    }
    fun getUser() : LiveData<List<RoutineEntity>>{
            return routineDAO.getUser()
    }
    fun deleteUser(routineEntity: RoutineEntity){
        return routineDAO.deleteRoutine(routineEntity)

    }

    fun updateUser(routineEntity: RoutineEntity){
        return routineDAO.updateRoutine(routineEntity)
    }
}