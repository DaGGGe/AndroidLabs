package com.app.ghostretrofit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.ghostretrofit.databinding.FragmentFirstBinding
import com.app.ghostretrofit.viewmodel.FirstViewModel


class StartFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    //ініціалізація viewmodel
    private val viewModel by viewModels<FirstViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            viewModel.start()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.destination.observe(viewLifecycleOwner) { status ->
            if (status != null) {
                val action = StartFragmentDirections.actionFirstFragmentToDetailFragment()
                findNavController().navigate(action)
            }
        }


    }
}