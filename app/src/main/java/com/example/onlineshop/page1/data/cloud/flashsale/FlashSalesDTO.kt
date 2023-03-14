package com.example.onlineshop.page1.data.cloud.flashsale

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 09.03.2023.
 */
class FlashSalesDTO(@SerializedName("flash_sale") val listFlashSaleDto: List<FlashSaleDTO>)