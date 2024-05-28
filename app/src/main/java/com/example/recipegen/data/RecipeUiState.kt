package com.example.recipegen.data

data class RecipeUiState(
    val recipeQuantity: Int = 0,
    val recipesGenerated: Boolean = false,
    val recipesAccepted: Boolean = false,
    val recipeList: List<Int> = listOf(),
    val ingredientList: List<Int> = listOf()
)
