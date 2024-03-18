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
                recipeQuantity = numberRecipes
            )
        }
    }

    fun setRecipesGenerated() {
        _uiState.update { currentState ->
            currentState.copy(
                recipesGenerated = true
            )
        }
    }

    fun resetRecipesGenerated() {
        _uiState.update { currentState ->
            currentState.copy(
                recipesGenerated = false
            )
        }
    }

    fun setRecipesAccepted() {
        _uiState.update { currentState ->
            currentState.copy(
                recipesAccepted = true
            )
        }
    }

    fun resetRecipesAccepted() {
        _uiState.update { currentState ->
            currentState.copy(
                recipesAccepted = false
            )
        }
    }

    fun updateRecipeList(newList: List<Int>) {
        _uiState.update { currentState ->
            currentState.copy(
                recipeList = newList
            )
        }
    }

    fun resetRecipeGenProcess() {
        _uiState.value = RecipeUiState()
    }

    fun emailIngredientList() {

    }

}