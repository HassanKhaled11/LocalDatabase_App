package com.example.roomdatabase.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R


class Login : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_login2, container, false)

        var btn : Button  = view.findViewById(R.id.logbut)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_login4_to_details2)


        }

        return view
    }

}