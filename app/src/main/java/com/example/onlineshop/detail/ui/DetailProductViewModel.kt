package com.example.onlineshop.detail.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.detail.domain.ProductDetailIteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailProductViewModel @Inject constructor(iteractor: ProductDetailIteractor): ViewModel() {

    init {
        viewModelScope.launch {
            Log.i("vital", "${iteractor.fetchProductDetail()}")
        }

    }
}