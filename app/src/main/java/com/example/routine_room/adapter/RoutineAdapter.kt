package com.example.routine_room.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.routine_room.R
import com.example.routine_room.data.RoutineEntity

class RoutineAdapter(
    val context: Context,
    val routineList: MutableList<RoutineEntity>,
    val onclicked: Onclicked
) : RecyclerView.Adapter<RoutineViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val inflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_layout,parent,false)
        return RoutineViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        holder.setData(routineList[position])
        holder.editBtn.setOnClickListener {
            onclicked.onEditClick(routineList.get(position))
        }
        holder.deleteBtn.setOnClickListener {
            onclicked.onDeleteClick(routineList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return routineList.size
    }
}
class RoutineViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    lateinit var name : TextView
    lateinit var desc : TextView
    lateinit var quintity : TextView
    lateinit var edit : ImageView
    lateinit var delete : ImageView
    lateinit var deleteBtn : Button
    lateinit var editBtn : Button


    init {
        name = itemView.findViewById(R.id.TvName)
        desc = itemView.findViewById(R.id.TvDesc)
        quintity = itemView.findViewById(R.id.TvQuantity)
        edit = itemView.findViewById(R.id.TvEdit)
        delete = itemView.findViewById(R.id.TvDelete)
        deleteBtn =itemView.findViewById(R.id.TvDelete)
        editBtn =itemView.findViewById(R.id.TvEdit)
    }
    fun setData(routineEntity : RoutineEntity){
        name.text = routineEntity.name
        desc.text = routineEntity.Desc
        quintity.text = routineEntity.quantity

    }
}

