package com.example.recipegen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Button
import com.example.recipegen.R
import com.example.recipegen.data.DataSource

@Composable
fun RecipeScreen(
    recipeList: List<Int>,
    onSeeIngredientsButtonClicked: (Int) -> Unit,
    onRegenerateButtonClicked: (Int) -> Unit,
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
                text = "Your Generated Recipes for this week are: "
            )
            //Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            for (recipe in recipeList) {
                Text(
                    text = DataSource.recipeNames[recipe]
                )
            }
            SeeIngredientsButton(
                onClick = { onSeeIngredientsButtonClicked(1) }
            )
            RegenerateButton(
                onClick = { onRegenerateButtonClicked(1) }
            )
            CancelButton(
                onClick = { onCancelButtonClicked(1) }
            )
        }
    }
}

@Composable
fun SeeIngredientsButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = dimensionResource(id = R.dimen.large_divider))
    ) {
        Text(stringResource(R.string.see_ingredients))
    }
}

@Composable
fun RegenerateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = dimensionResource(id = R.dimen.large_divider))
    ) {
        Text(stringResource(R.string.regenerate_recipes))
    }
}

@Composable
fun CancelButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = dimensionResource(id = R.dimen.large_divider))
    ) {
        Text(stringResource(R.string.cancel))
    }
}