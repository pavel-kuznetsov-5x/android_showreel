package com.example.android_showreel.screens.multithreading

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_showreel.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_text.*

class PrimeNumbersAdapter() : RecyclerView.Adapter<VHPrimeNumber>() {
    lateinit var context: Context
    val items = mutableListOf<Int>();

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        context = recyclerView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHPrimeNumber {
        return VHPrimeNumber(LayoutInflater.from(context).inflate(R.layout.item_text, null, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VHPrimeNumber, position: Int) {
        holder.tvText.text = items[position].toString()
    }

    fun add(it: Int) {
        items.add(it)
        notifyItemInserted(items.size)
    }
}

class VHPrimeNumber(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    override val containerView: View?
        get() = itemView
}