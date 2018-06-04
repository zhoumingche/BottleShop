package com.mick.bottleshop.model


data class WineListResponse(
        val value: Value?
)

data class Value(
        val machineName: Any?,
        val machineCode: String?,
        val pipeCount: Int?,
        val productVoList: List<ProductVo?>?
)

data class ProductVo(
        val id: String?,
        val dropCode: Int?,
        val remainder: Int?,
        val salePrice: Int?,
        val saleUnit: String?,
        val freeTastedAmount: Int?,
        val isFreeTasted: Int?,
        val brandName: String?,
        val imageUrl: String?,
        val proof: Int?,
        val describe: String?
)