package com.example.onlineshop.detail.ui

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.databinding.FragmentDetailProductBinding
import com.example.onlineshop.di.App
import javax.inject.Inject

class DetailProductFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailProductViewModel

    private var _binding: FragmentDetailProductBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           binding.toBackImageButton.setOnClickListener{
           this.findNavController().navigateUp()
        }
    }

}