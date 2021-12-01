package com.changers.thedogapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.changers.thedogapi.Breed
import com.changers.thedogapi.databinding.FragmentMainItemBinding

class BreedAdapter(var list: List<Breed>,private val listener: OnItemClickListener) : RecyclerView.Adapter<BreedAdapter.ViewHolder>() {

    fun setBreedList(list:List<Breed>){
        this.list=list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentMainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = list[position]
        holder.bind(person)
        holder.itemView.setOnClickListener {
            listener.onClick(list[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val binding: FragmentMainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(breed: Breed) {
            binding.breed = breed
            binding.executePendingBindings()
        }

    }


    interface OnItemClickListener {
        fun onClick(breed: Breed)
    }
}