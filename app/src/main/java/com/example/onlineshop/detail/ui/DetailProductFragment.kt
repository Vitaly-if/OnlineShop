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
import com.example.onlineshop.detail.ui.adapter.ColorsAdapter
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
        val recyclerColors = binding.colorProductImagesRecyclerView

        val adapterImages = ImagesAdapter(object : ClickListener {
            override fun click(item: String) {
                Log.i("vital", "click image $item")
            }
        })
        val adapterColors= ColorsAdapter(object : ClickListener {
            override fun click(item: String) {
                Log.i("vital", "click color $item")
            }
        })
        recyclerViewImage.adapter = adapterImages
        recyclerColors.adapter = adapterColors

        viewModel.observeProductDetailUi(this) {
            it.map(mapper)
            adapterImages.map(it.images())
            adapterColors.map(it.colors())
        }
        binding.toBackImageButton.setOnClickListener {
            this.findNavController().navigateUp()
        }
    }

}