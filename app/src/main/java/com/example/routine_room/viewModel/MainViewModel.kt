package com.example.routine_room.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.routine_room.data.RoutineEntity
import com.example.routine_room.repo.MyRepository

class MainViewModel(val repository : MyRepository) : ViewModel() {

    fun createUser(routineEntity: RoutineEntity){
        repository.createUser(routineEntity)
    }

    fun getUser() : LiveData<List<RoutineEntity>>{
        return repository.getUser()
    }
    fun deleteUser(routineEntity: RoutineEntity){
        return repository.deleteUser(routineEntity)
    }

    fun updateUser(routineEntity: RoutineEntity){
        return repository.deleteUser(routineEntity)
    }

}