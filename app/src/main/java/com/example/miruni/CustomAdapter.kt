package com.example.miruni

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(
    private val context: Context,
    private val memoryList: List<Memory>
) : BaseAdapter() {

    override fun getCount(): Int = memoryList.size

    override fun getItem(position: Int): Any = memoryList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_layout, parent, false)

        val dateText = view.findViewById<TextView>(R.id.text_date)
        val nameText = view.findViewById<TextView>(R.id.text_name)
        val descriptionText = view.findViewById<TextView>(R.id.text_description)

        val memory = memoryList[position]

        dateText.text = memory.date
        nameText.text = memory.name
        descriptionText.text = memory.description

        return view
    }
}
