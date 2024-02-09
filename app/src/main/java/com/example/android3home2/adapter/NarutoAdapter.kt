package com.example.android3home2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3home2.data.AnimeModels
import com.example.android3home2.databinding.ItemBinding

class NarutoAdapter : RecyclerView.Adapter<NarutoAdapter.NarutoViewHolder>() {
    private var narutoList = mutableListOf<AnimeModels>()

    fun setNaruto(narutoList: MutableList<AnimeModels>) {
        this.narutoList = narutoList
        notifyDataSetChanged()
    }

    inner class NarutoViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(narutoData: AnimeModels) {
            binding.ivItem.setImageResource(narutoData.image)
            binding.textItem.text = narutoData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NarutoViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NarutoViewHolder(binding)
    }

    override fun getItemCount() = narutoList.size

    override fun onBindViewHolder(holder: NarutoViewHolder, position: Int) {
        holder.onBind(narutoList[position])
    }
}