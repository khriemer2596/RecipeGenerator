package com.example.recipegen.data

import androidx.compose.ui.res.stringResource
import com.example.recipegen.R

object DataSource {
    val recipeQuantities = listOf(
        Pair(R.string.one_meal, 1),
        Pair(R.string.two_meals, 2),
        Pair(R.string.three_meals, 3),
        Pair(R.string.four_meals, 4),
        Pair(R.string.five_meals, 5),
        Pair(R.string.six_meals, 6),
        Pair(R.string.seven_meals, 7)
    )

    // TODO: Add actual recipes
    // Asian Rice Bowls: indexes 3-15
    val recipeNames = listOf(
        "Tacos",
        "Salmon Bowls",
        "Burgers",
        "Vietnamese Chicken and Rice Bowls",
        "Sriracha Pork Stir Fry",
        "Beef Banh Mi Bowls",
        "Sweet Ginger Chicken Stir-Fry Bowls",
        "Saucy Chicken and Pepper Stir-Fry",
        "Ginger and Ponzu Turkey Bowls",
        "Hibachi Style Steak and Rice Bowls",
        "Hibachi Style Chicken Stir-Fry",
        "Sweet Soy Ramen Stir Fry",
        "Moo Shu Beef Bowls",
        "Peanut Chicken Stir-Fry Bowls",
        "Sweet Potato and Broccoli Donburi with Fried Egg",
        "Turkey Banh Mi Bowls"
    )

    val recipeIngredient = listOf(
        listOf("tortillas", "ground turkey 93%", "rice", "mexican cheese",
            "red bell pepper", "green bell pepper", "yellow onion", "taco seasoning"),
        listOf("sushi rice", "salmon", "rice wine vinegar", "sugar",
            "sesame oil", "cucumber", "carrots", "lime", "mayo", "sriracha"),
        listOf("buns", "ground turkey 85%", "pepper jack", "fries", "ketchup",
            "barbecue sauce", "worcestershire sauce", "breadcrumbs"),
        listOf("rice", "lime", "garlic", "chicken breast",
            "ponzu", "cucumber", "carrots", "peanuts", "mayo", "sriracha"),
        listOf("rice", "lime", "garlic", "scallions", "sweet soy glaze",
            "peanuts", "coleslaw mix", "ground pork"),
        listOf("rice", "lime", "cucumber", "garlic", "yellow onion", "ponzu",
            "carrots", "mayo", "sriracha", "ground beef"),
        listOf("rice", "garlic", "red bell pepper", "umami ginger sauce",
            "scallions", "chicken breast"),
        listOf("rice", "garlic", "long green pepper", "soy sauce",
            "ponzu", "chicken breast", "sweet thai chili sauce", "cornstarch", "ginger"),
        listOf("rice", "garlic", "lime", "zucchini", "sweet soy glaze",
            "carrots", "ground turkey", "ginger", "sriracha", "ponzu"),
        listOf("rice", "zucchini", "yellow onion", "mayo",
            "scallions", "steak", "ponzu", "fry seasoning", "sriracha", "sesame seeds"),
        listOf("rice", "garlic", "long green pepper", "yellow onion",
            "mayo", "chicken breast", "fry seasoning", "sriracha", "ponzu"),
        listOf("sugar snap peas", "garlic", "red bell pepper", "ginger",
            "scallions", "garlic", "soy sauce", "sweet thai chili sauce", "cornstarch",
            "rice wine vinegar", "ramen noodles"),
        listOf("rice", "garlic", "ginger", "lime", "katsu sauce", "ponzu",
            "scallions", "sweet thai chili sauce", "ground beef", "coleslaw mix"),
        listOf("rice", "garlic", "cucumber", "ponzu", "carrots", "lime",
            "sweet thai chili sauce", "chicken breast", "soy sauce", "peanut butter"),
        listOf("rice", "broccoli", "sriracha", "mayo",
            "fry seasoning", "sweet potato", "sweet potato", "cucumber", "lime", "scallions"),
        listOf("rice", "yellow onion", "lime", "garlic", "cucumber", "carrots",
            "mayo", "sriracha", "ground turkey", "ponzu"),
    )
}