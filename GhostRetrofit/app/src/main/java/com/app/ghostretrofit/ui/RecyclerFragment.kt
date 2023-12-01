package com.app.ghostretrofit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.ghostretrofit.databinding.FragmentDetailBinding
import com.app.ghostretrofit.ui.recyclerview.CustomAdapter
import com.app.ghostretrofit.viewmodel.RecycleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecyclerFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    //ініціалізація viewmodel
    val detailViewModel: RecycleViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclers.setHasFixedSize(true)
        binding.recyclers.layoutManager = LinearLayoutManager(requireContext())
        detailViewModel.projectsLiveData.observe(viewLifecycleOwner) { status ->
            binding.recyclers.adapter = CustomAdapter(requireContext(), status)
        }
    }
}