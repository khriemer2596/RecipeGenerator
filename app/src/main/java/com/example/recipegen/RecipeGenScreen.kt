package com.example.recipegen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.recipegen.ui.RecipeGenViewModel
import com.example.recipegen.ui.HomeScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipegen.ui.IngredientScreen
import com.example.recipegen.ui.RecipeScreen
import androidx.compose.material3.Icon
import androidx.navigation.compose.ComposeNavigator
import com.example.recipegen.data.DataSource

enum class RecipeGenScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Recipes(title = R.string.recipe_screen),
    Ingredients(title = R.string.ingredient_screen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeGenAppBar(
    currentScreen: RecipeGenScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )

}

@Composable
fun RecipeGenApp(
    viewModel: RecipeGenViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val currentScreen = RecipeGenScreen.valueOf(RecipeGenScreen.Home.name)
    Scaffold(
        topBar = {
            RecipeGenAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = RecipeGenScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = RecipeGenScreen.Home.name) {
                HomeScreen(
                    recipeQuantities = DataSource.recipeQuantities,
                    onSubmitButtonClicked = {
                        viewModel.setQuantity(it)
                        navController.navigate(RecipeGenScreen.Recipes.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
            composable(route = RecipeGenScreen.Recipes.name) {
                RecipeScreen(
                    onSeeIngredientsButtonClicked = {
                        viewModel.setQuantity(it)
                        navController.navigate(RecipeGenScreen.Ingredients.name)
                    },
                    onCancelButtonClicked = { cancelRecipeGeneration(viewModel, navController) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
            composable(route = RecipeGenScreen.Ingredients.name) {
                IngredientScreen(
                    onEmailIngredientListButtonClicked = { emailIngredientList() },
                    onStartNewButtonClicked = {
                        viewModel.setQuantity(it)
                        navController.navigate(RecipeGenScreen.Home.name)
                    },
                    onCancelButtonClicked = { cancelRecipeGeneration(viewModel, navController) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
    }
}

private fun cancelRecipeGeneration(
    viewModel: RecipeGenViewModel,
    navController: NavHostController
) {
    viewModel.resetRecipeGenProcess()
    navController.popBackStack(RecipeGenScreen.Home.name, inclusive = false)
}

private fun emailIngredientList() {

}

