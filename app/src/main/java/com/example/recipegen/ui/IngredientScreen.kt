package com.example.recipegen.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.recipegen.R
import com.example.recipegen.data.DataSource

@Composable
fun IngredientScreen(
    ingredientList: List<Int>,
    onEmailIngredientListButtonClicked: (Int) -> Unit,
    onHomeButtonClicked: (Int) -> Unit,
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

        val ingredients = mutableMapOf<String, Int>()

        /*
        var riceAddition = 1
        var garlicAddition = 1
        var gingerAddition = 1
        var soySauceAddition = 1
        var riceWineVinegarAddition = 1
        var cornStarchAddition = 1
        var srirachaAddition = 1
        var sweetThaiAddition = 1
        var sesameOilAddition = 1
        */

        for (ingredient in ingredientList) {
            for (i in 0..<DataSource.recipeIngredient[ingredient].size) {
                if (ingredients.containsKey(DataSource.recipeIngredient[ingredient][i])) {
                    /*
                    if (DataSource.recipeIngredient[ingredient][i] == "rice") {
                        riceAddition += 1
                        if (riceAddition > 4) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            riceAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "garlic") {
                        garlicAddition += 1
                        if (garlicAddition > 6) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            garlicAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "ginger") {
                        gingerAddition += 1
                        if (gingerAddition > 7) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            gingerAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "soy sauce") {
                        soySauceAddition += 1
                        if (soySauceAddition > 10) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            soySauceAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "rice wine vinegar") {
                        riceWineVinegarAddition += 1
                        if (riceWineVinegarAddition > 10) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            riceWineVinegarAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "cornstarch") {
                        cornStarchAddition += 1
                        if (cornStarchAddition > 10) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            cornStarchAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "sriracha") {
                        srirachaAddition += 1
                        if (srirachaAddition > 10) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            srirachaAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "sweet thai chili sauce") {
                        sweetThaiAddition += 1
                        if (sweetThaiAddition > 10) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            sweetThaiAddition = 1
                        }
                    }
                    else if (DataSource.recipeIngredient[ingredient][i] == "sesame oil") {
                        sesameOilAddition += 1
                        if (sesameOilAddition > 10) {
                            ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                            sesameOilAddition = 1
                        }
                    }
                    */
                    //else {
                        ingredients[DataSource.recipeIngredient[ingredient][i]] = ingredients[DataSource.recipeIngredient[ingredient][i]]!! + 1
                    //}
                }
                else {
                    ingredients[DataSource.recipeIngredient[ingredient][i]] = 1
                }
            }
        }

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .weight(0.5f, fill = false)
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
        //TODO: Add other buttons?
        val context = LocalContext.current

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        context.sendMail(
                            to = "",
                            subject = "Ingredients List",
                            body = ingredients.toString()
                        )
                    }
                ) {
                    Text("Email this List")
                }
                Button(
                    onClick = { onHomeButtonClicked(1) }
                ) {
                    Text("Back to Home")
                }
            }
        }
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

fun Context.sendMail(to: String, subject: String, body: String) {
    // TODO: Email with body already containing ingredients list in better format?
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, body)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // TODO: Handle case where no email app is available
    } catch (t: Throwable) {
        // TODO: Handle potential other type of exceptions
    }
}


