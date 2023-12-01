package com.app.labtwoghost.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.labtwoghost.data.model.ModelOfFilm
import com.app.labtwoghost.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //взяття даних з минулого фрагменту
        val dataModel: ModelOfFilm? = arguments?.getParcelable("data")
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        //встановлення цих даних на екрані
        binding.textViewForDetail.text= dataModel?.details
        binding.textViewForName.text= dataModel?.name
        Glide.with(requireContext())
            .load(dataModel?.image)
            .circleCrop()
            .into(binding.imageForDetail)
        return binding.root
    }
}