package com.example.com1nav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment (R.layout.fragment_login){
    private val args: LoginFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val usernameDeepLink = args.username //argument created in nav_graph
        edit_text_username.setText(usernameDeepLink) //deeplink created in nav_graph

        button_confirm.setOnClickListener{

            val username = edit_text_username.text.toString()
            val password = edit_text_password.text.toString()

            //rebuild the project before write down below val, it needs to generate some code which only happens on compile time
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password)
            findNavController().navigate(action) //findNavController is kotlin extension function on the fragment class
        }
    }
}


