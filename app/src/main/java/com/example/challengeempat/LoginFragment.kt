package com.example.challengeempat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import com.example.challengeempat.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding
    private lateinit var sharedPref: SharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireNotNull(activity).application ;
        setup(context)
        binding?.btnLogin?.setOnClickListener {
            sharedPref.isLogin = true
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        if (sharedPref.isLogin){
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding?.ctaToRegister?.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun setup(context: Context){
        sharedPref = SharedPref(context)
    }
}