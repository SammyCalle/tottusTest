package com.example.tottustest.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.tottustest.R
import com.example.tottustest.data.model.request.CreateNewUserRequest
import com.example.tottustest.ui.interfaces.DrawerLocker
import com.example.tottustest.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.android.viewmodel.ext.android.viewModel


class RegistrationFragment : Fragment() {

    private val registrationViewModel  by viewModel<RegistrationViewModel>()

    private var name : String? = null
    private var surname : String? = null
    private var email : String? = null
    private var password : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = registrationViewModel
        viewModel.created.observe(viewLifecycleOwner
        , Observer {moveBackToLogin(it)})
        buttonCreation.setOnClickListener {
            name = editTextTextPersonName.text.toString()
            surname = editTextTextPersonName2.text.toString()
            email = editTextTextEmailAddress.text.toString()
            password = editTextTextPassword.text.toString()
            val newUserRequest = CreateNewUserRequest(email!!,password!!,name!!,surname!!)
        }
    }

    private fun moveBackToLogin(it : Boolean){
        requireView().findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
    }
}