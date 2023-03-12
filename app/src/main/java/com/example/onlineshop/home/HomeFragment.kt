package com.example.onlineshop.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.di.App
import com.example.onlineshop.home.adapter.category.CategoryAdapter
import com.example.onlineshop.home.adapter.flashsale.FlashSaleAdapter
import com.example.onlineshop.home.adapter.latest.LatestAdapter
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerCategoryView = binding.categoryRecyclerView
        val recyclerLatestView = binding.latestRecyclerView
        val recyclerFlashSale = binding.flashSaleRecyclerView

        val flashSaleAdapter = FlashSaleAdapter()
        val latestAdapter = LatestAdapter()
        val categoryAdapter = CategoryAdapter()

        recyclerCategoryView.adapter = categoryAdapter
        recyclerLatestView.adapter = latestAdapter
        recyclerFlashSale.adapter = flashSaleAdapter

        categoryAdapter.map(
            listOf(
                CategoryUi("0", "Phone", R.drawable.ic_phone),
                CategoryUi("1", "Headphones", R.drawable.ic_headphones),
                CategoryUi("2", "Games", R.drawable.ic_games),
                CategoryUi("3", "Cars", R.drawable.ic_cars),
                CategoryUi("4", "Furniture", R.drawable.ic_furniture),
                CategoryUi("5", "Kids", R.drawable.ic_kids)
            )
        )

        homeViewModel.observeflashSasleNavigation(this) {
            Navigation.findNavController(view)
                .navigate(R.id.action_navigation_home_to_navigation_detail_product)

        }
        homeViewModel.observeLatestList(this) {
            latestAdapter.map(it)
        }
        homeViewModel.observeFlashSaleList(this) {
            flashSaleAdapter.map(it)
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        val bottomNavigationView = requireActivity()?.findViewById<CardView>(R.id.cardView)
        bottomNavigationView.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}