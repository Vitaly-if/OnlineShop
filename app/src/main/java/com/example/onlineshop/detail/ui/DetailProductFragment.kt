package com.example.onlineshop.detail.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.databinding.FragmentDetailProductBinding
import com.example.onlineshop.detail.ui.adapter.ClickListener
import com.example.onlineshop.detail.ui.adapter.ImagesAdapter
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

        val mapper = CardProductUi(binding)
        val recyclerViewImage = binding.productImagesRecyclerView

        val adapterImages = ImagesAdapter(object : ClickListener {
            override fun click(item: String) {
                Log.i("vital", "click image")
            }
        })
        recyclerViewImage.adapter = adapterImages
        adapterImages.map(
            listOf(
                "https://assets.reebok.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/3613ebaf6ed24a609818ac63000250a3_9366/Classic_Leather_Shoes_-_Toddler_White_FZ2093_01_standard.jpg",
                "https://assets.reebok.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/a94fbe7d8dfb4d3bbaf9ac63000135ed_9366/Classic_Leather_Shoes_-_Toddler_White_FZ2093_03_standard.jpg",
                "https://assets.reebok.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/1fd1b80693d34f2584b0ac6300034598_9366/Classic_Leather_Shoes_-_Toddler_White_FZ2093_05_standard.jpg"
            )
        )
        binding.toBackImageButton.setOnClickListener {
            this.findNavController().navigateUp()
        }
    }

}