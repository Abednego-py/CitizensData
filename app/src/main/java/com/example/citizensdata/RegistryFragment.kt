package com.example.citizensdata

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.citizensdata.databinding.FragmentRegistryBinding
import com.example.citizensdata.recycler.appAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RegistryFragment : Fragment(), appAdapter.OnItemClickListener {

    private lateinit var _binding : FragmentRegistryBinding

    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val db = (requireActivity().application as MainApp).database
        val data = db.appDao().retrieve()

        binding.recyclerList.adapter = appAdapter(data,this)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_registryFragment_to_loginFragment)
        }

    }

    override fun onItemClick(position: Int) {
        val db = (requireActivity().application as MainApp).database
        val data = db.appDao().retrieve()
        val citizenData = data[position]

        val action = RegistryFragmentDirections.actionRegistryFragmentToUpdateFragment(citizenData)
        findNavController().navigate(action)

    }


}