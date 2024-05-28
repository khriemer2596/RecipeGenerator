package com.example.recipegen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.recipegen.R
import com.example.recipegen.data.DataSource

@Composable
fun IngredientScreen(
    ingredientList: List<Int>,
    onEmailIngredientListButtonClicked: (Int) -> Unit,
    onStartNewButtonClicked: (Int) -> Unit,
    onCancelButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = "Here are the ingredients you need: "
            )
        }
        //Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        val ingredients = mutableListOf<String>()
        for (ingredient in ingredientList) {
            for (i in 0..<DataSource.recipeIngredient[ingredient].size) {
                ingredients.add(DataSource.recipeIngredient[ingredient][i])
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
        )
        {
            items(ingredients.size - 1) { ingredient ->
                IngredientRow(ingredients[ingredient])
            }
        }
        //TODO: Add other buttons
    }
}

@Composable
fun IngredientRow(ingredient: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = ingredient,
            textAlign = TextAlign.Start
        )
    }
}
