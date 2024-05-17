package com.example.recipegen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.RecipeGenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeGenTheme {
                // A surface container using the 'background' color from the theme
                RecipeGenApp()
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun RecipeGenPreview() {
    RecipeGenTheme {
        RecipeGenApp()
    }
}

 */

