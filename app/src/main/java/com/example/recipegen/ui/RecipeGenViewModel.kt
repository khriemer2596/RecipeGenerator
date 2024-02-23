package com.example.recipegen.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.recipegen.data.RecipeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeGenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()

    var numberRecipes by mutableStateOf("")
        private set

    fun setQuantity(numberRecipes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                recipeQuantity = numberRecipes.toInt()
            )
        }
    }

    fun resetRecipeGenProcess() {
        _uiState.value = RecipeUiState()
    }

    fun emailIngredientList() {

    }

}