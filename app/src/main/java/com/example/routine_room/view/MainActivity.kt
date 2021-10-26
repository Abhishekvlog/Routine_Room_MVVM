package com.example.routine_room.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.routine_room.R
import com.example.routine_room.adapter.Onclicked
import com.example.routine_room.adapter.RoutineAdapter
import com.example.routine_room.data.RoutineDAO
import com.example.routine_room.data.RoutineDatabase
import com.example.routine_room.data.RoutineEntity
import com.example.routine_room.repo.MyRepository
import com.example.routine_room.viewModel.MainViewModel
import com.example.routine_room.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() , Onclicked{

    lateinit var routineAdapter: RoutineAdapter
    private val routineList : MutableList<RoutineEntity> = mutableListOf()

    lateinit var viewModel : MainViewModel
    lateinit var repository : MyRepository
    lateinit var taskappDAO: RoutineDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        taskappDAO = RoutineDatabase.getRoutineDatabase(this).getRoutineDao()

        repository = MyRepository(taskappDAO)

        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)

        val Madapter = RoutineAdapter(this, routineList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = routineAdapter


        viewModel.getUser().observe(this, Observer {
            routineList.clear()
            routineList.addAll(it)
            Madapter.notifyDataSetChanged()
        })

        BtnAdd.setOnClickListener {
            val Name = EtRoutineName.text.toString()
            val desc = EtRoutineDesc.text.toString()
            val Quantity = EtRoutineQuantity.text.toString()

            val newRoutine = RoutineEntity(Name , desc, Quantity)

            CoroutineScope(Dispatchers.IO).launch {
                viewModel.createUser(newRoutine)
            }


        }


    }

    override fun onEditClick(routineEntity: RoutineEntity) {
        val newRoutine = RoutineEntity("Cycling", "run", "5 Km")
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.updateUser(newRoutine)

        }
    }

    override fun onDeleteClick(routineEntity: RoutineEntity) {
        //val deleteRoutine = RoutineEntity("Cycling", "run", "5 Km")
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.deleteUser(routineEntity)
        }
    }
}