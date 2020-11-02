package com.example.tottustest.ui.login

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.tottustest.R
import com.example.tottustest.data.model.response.ValidateLoginResponse
import com.example.tottustest.utils.Intents
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val loginViewModel  by viewModel<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = loginViewModel
        loginViewModel.userData.observe(viewLifecycleOwner, Observer {
            moveToHome(it)
        })
        loginViewModel.showError.observe(viewLifecycleOwner, Observer {
            moveToCreateAccount()
        })

        login.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            viewModel.userLogin(username,password)
        }
    }

    private fun moveToHome(userData : ValidateLoginResponse?){
        activity?.intent?.putExtra(Intents.id,userData!!.id)
        activity?.intent?.putExtra(Intents.name,userData!!.nombre)
        activity?.intent?.putExtra(Intents.apellido,userData!!.apellido)
        requireView().findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

    private fun moveToCreateAccount(){
        requireView().findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
    }
}