package com.example.citizensdata

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.citizensdata.databinding.FragmentLoginBinding
import com.example.citizensdata.db.appEntity
import kotlinx.android.synthetic.main.fragment_update.*


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var _binding : FragmentLoginBinding

    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val db = (requireActivity().application as MainApp).database

        binding.login.setOnClickListener {
            val name = binding.username.text.toString()
            val address = binding.address.text.toString()
            val age = binding.age.text.toString()
            val occupation = binding.occupation.text.toString()
            val status = binding.maritalStatus.text.toString()

            if (inputCheck(name, address, age, status, occupation)) {
                val appEntity = appEntity(
                    name = name,
                    Address = address,
                    Age = Integer.parseInt(age),
                    occupation = occupation,
                    marital_status = status
                )
                db.appDao().insert(appEntity)
                Toast.makeText(context, "Citizen Info registered", Toast.LENGTH_SHORT)
                    .show()
                findNavController().navigate(
                    R.id.action_loginFragment_to_registryFragment
                )
            }
            else{
                Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun inputCheck(name: String, address: String, age: String, status: String, occupation: String)
            : Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(age)
                || TextUtils.isEmpty(status) || TextUtils.isEmpty(occupation))
    }


}