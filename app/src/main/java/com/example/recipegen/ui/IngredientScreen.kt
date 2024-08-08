package com.example.recipegen.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
        val ingredients = mutableMapOf<String, Int>()
        for (ingredient in ingredientList) {
            for (i in 0..<DataSource.recipeIngredient[ingredient].size) {
                if (ingredients.containsKey(DataSource.recipeIngredient[ingredient][i])) {
                    ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                }
                else {
                    ingredients[DataSource.recipeIngredient[ingredient][i]] = 1
                }
            }
        }

        LazyColumn(
            //contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            item {
                Row() {
                    TableCell(text = "Ingredient", weight = 0.7f)
                    TableCell(text = "Quantity", weight = 0.3f)
                }
            }
             items(items = ingredients.keys.toTypedArray()){
                val quantity = ingredients[it]
                Row(Modifier.fillMaxWidth()) {
                    TableCell(text = it, weight = 0.7f)
                    TableCell(text = quantity.toString(), weight = 0.3f)
                }
            }
        }
        //TODO: Add other buttons
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, colorResource(R.color.app_blue))
            .weight(weight)
            .padding(8.dp)
    )
}

