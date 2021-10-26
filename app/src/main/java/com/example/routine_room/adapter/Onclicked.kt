package com.example.routine_room.adapter

import com.example.routine_room.data.RoutineEntity

interface Onclicked {
    fun onEditClick(routineEntity: RoutineEntity)
    fun onDeleteClick(routineEntity: RoutineEntity)
}