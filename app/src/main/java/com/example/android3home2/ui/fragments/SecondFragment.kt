package com.example.android3home2.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android3home2.R
import com.example.android3home2.data.AnimeModels
import com.example.android3home2.data.viewModels.NarutoViewModel
import com.example.android3home2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!
    private val viewModel by activityViewModels<NarutoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBack()

    }

    private fun goBack() = with(binding) {
        binding.btnSec.setOnClickListener {
            progressbar2.isVisible = true
            Handler().postDelayed({
                progressbar2.isVisible = false
                viewModel.addNaruto(
                    AnimeModels(
                    image = R.drawable.narutoo,
                    edinName.text.toString().trim()
                )
                )

                findNavController().navigateUp()
            }, 2000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}