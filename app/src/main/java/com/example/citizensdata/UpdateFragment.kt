package com.example.citizensdata

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.citizensdata.db.appEntity
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import org.w3c.dom.Text


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)


        view.username_update.setText(args.currentUser.name)
        view.address_update.setText(args.currentUser.Address)
        view.age_update.setText(args.currentUser.Age.toString())
        view.marital_status_update.setText(args.currentUser.marital_status)
        view.occupation_update.setText(args.currentUser.occupation)

        view.login_update.setOnClickListener{
            updateItem()
        }
        return view
    }

    private fun updateItem() {
        val name = username_update.text.toString()
        val address = address_update.text.toString()
        val age = age_update.text.toString()
        val status = marital_status_update.text.toString()
        val occupation = occupation_update.text.toString()

        if(inputCheck(name, address, age, status, occupation)) {
            val updatedData = appEntity(args.currentUser.id, name, address, Integer.parseInt(age), occupation, status)

            val db = (requireActivity().application as MainApp).database
            db.appDao().update(updatedData)
            val action = UpdateFragmentDirections.actionUpdateFragmentToRegistryFragment()
            findNavController().navigate(action)
        }
        else{
            Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name: String, address: String, age: String, status: String, occupation: String)
    : Boolean{
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(age)
                || TextUtils.isEmpty(status) || TextUtils.isEmpty(occupation))
    }

}