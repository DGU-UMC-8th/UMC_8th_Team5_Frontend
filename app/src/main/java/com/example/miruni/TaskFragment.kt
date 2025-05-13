package com.example.miruni

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.miruni.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CustomAdapter
    private val memoryList = ArrayList<Memory>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        memoryList.add(
            Memory(
                date = "May 13 2025",
                name = "회고 #1",
                description = "Here is my description in my memories #1"
            )
        )

        adapter = CustomAdapter(requireContext(), memoryList)
        binding.mainProfileLv.adapter = adapter

        binding.iconPlus.setOnClickListener {
            val newMemory = Memory(
                date = "May 13 2025",
                name = "회고 #${memoryList.size + 1}",
                description = "Here is my description in my memories #${memoryList.size + 1}"
            )

            memoryList.add(newMemory)
            adapter.notifyDataSetChanged()

            binding.mainProfileLv.post {
                binding.mainProfileLv.setSelection(adapter.count - 1)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}