package com.example.android3home2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android3home2.R
import com.example.android3home2.adapter.NarutoAdapter
import com.example.android3home2.data.viewModels.NarutoViewModel
import com.example.android3home2.databinding.FragmentFirstBinding
import java.util.logging.Handler

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private val narutoAdapter = NarutoAdapter()
    private val viewModel by activityViewModels<NarutoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        recudoSaninMod()

    }

    private fun initialize() = with(binding) {
        viewModel.narutoLiveData.observe(viewLifecycleOwner) { UiState->
            rvFirst.adapter = narutoAdapter
            UiState.success?.let {
                narutoAdapter.setNaruto(it.toMutableList())
            }
        }
    }

    private fun recudoSaninMod() = with(binding) {
        btnFirst.setOnClickListener {
            progressbar.isVisible = true
            android.os.Handler().postDelayed(
                {
                    progressbar.isVisible = false
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                },
                3000
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}