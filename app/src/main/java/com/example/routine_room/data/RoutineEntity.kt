package com.example.routine_room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routine_table")
data class RoutineEntity(
    @ColumnInfo(name="name") var name : String,
    @ColumnInfo(name="desc")  var Desc : String,
    @ColumnInfo(name="quintity")  var quantity : String) {

    @PrimaryKey(autoGenerate =  true) @ColumnInfo(name= "id") var id : Int= 0

}