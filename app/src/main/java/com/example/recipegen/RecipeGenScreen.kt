package com.example.recipegen

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.recipegen.data.DataSource
import com.example.recipegen.data.RecipeUiState
import kotlin.random.Random

enum class RecipeGenScreen(var title: String) {
    Home(title = R.string.app_name.toString()),
    Recipes(title = R.string.recipe_screen.toString()),
    Ingredients(title = R.string.ingredient_screen.toString())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeGenAppBar(
    uiState: RecipeUiState,
    currentScreen: RecipeGenScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (uiState.recipesGenerated) {
        if (uiState.recipesAccepted) {
            currentScreen.title = stringResource(R.string.ingredient_screen)
        }
        else {
            currentScreen.title = stringResource(R.string.recipe_screen)
        }
    }
    else {
        currentScreen.title = stringResource(id = R.string.app_name)
    }
    TopAppBar(
        title = { Text(currentScreen.title) },
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
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = RecipeGenScreen.valueOf(
        backStackEntry?.destination?.route ?: RecipeGenScreen.Home.name
    )
    val uiState by viewModel.uiState.collectAsState()
    val generatedRecipeList by remember { mutableStateOf(listOf<Int>()) } // May not need

    Scaffold(
        topBar = {
            RecipeGenAppBar(
                uiState = uiState,
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null &&
                        currentScreen.title != stringResource(id = R.string.app_name),
                navigateUp = {
                    if (uiState.recipesAccepted) {
                        viewModel.resetRecipesAccepted()
                        navController.navigateUp()
                    }
                    else if (uiState.recipesGenerated) {
                        viewModel.resetRecipesGenerated()
                        navController.navigateUp()
                    }
                }
            )
        }
    ) { innerPadding ->

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
                        viewModel.updateRecipeList(generateRecipe(it))
                        viewModel.setRecipesGenerated()
                        navController.navigate(RecipeGenScreen.Recipes.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
            composable(route = RecipeGenScreen.Recipes.name) {
                RecipeScreen(
                    recipeList = uiState.recipeList,
                    onSeeIngredientsButtonClicked = {
                        viewModel.setRecipesAccepted()
                        navController.navigate(RecipeGenScreen.Ingredients.name)
                    },
                    onCancelButtonClicked = { cancelRecipeGeneration(viewModel, navController) },
                    onRegenerateButtonClicked = {
                        viewModel.updateRecipeList(generateRecipe(uiState.recipeQuantity))
                        viewModel.setRecipesGenerated()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
            composable(route = RecipeGenScreen.Ingredients.name) {
                IngredientScreen( // TODO: Implement Ingredient Screen; diplay with LazyColumn
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

private fun generateRecipe(it: Int): ArrayList<Int> {
    val listOfNums = arrayListOf<Int>()
    for (i in 1..it) {
        val recipe = Random.nextInt(0, 10)
        listOfNums.add(recipe)
    }
    return listOfNums
}

private fun emailIngredientList() {

}

