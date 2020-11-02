package com.example.tottustest.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tottustest.R
import com.example.tottustest.ui.interfaces.DrawerLocker


class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as DrawerLocker?)!!.setDrawerLocked(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
        playTimer()
    }

    private fun playTimer(){

        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                requireView().findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }
        }.start()
    }

}