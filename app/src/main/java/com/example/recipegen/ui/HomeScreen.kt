package com.example.recipegen.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.RecipeGenTheme
import com.example.recipegen.R
import com.example.recipegen.RecipeGenApp

@Composable
fun HomeScreen(
    recipeQuantities: List<Pair<Int, Int>>,
    onSubmitButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    HomeScreenLayout(
        recipeQuantities,
        onSubmitButtonClicked,
        modifier = modifier
    )
}

@Composable
fun HomeScreenLayout(
    recipeQuantities: List<Pair<Int, Int>>,
    onSubmitButtonClicked: (Int) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = stringResource(R.string.home_text_1)
            )
        }
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.home_text_2)
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                recipeQuantities.forEach { recipe ->
                    SubmitButton(
                        buttonNumberOfMeals = recipe.first,
                        onClick = { onSubmitButtonClicked(recipe.second) })
                }

            }
        }
    }
}

@Composable
fun SubmitButton(
    @StringRes buttonNumberOfMeals: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(buttonNumberOfMeals))
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeGenPreview() {
    RecipeGenTheme {
        RecipeGenApp()
    }
}