package com.ronalksp.orderyfood.model

import androidx.compose.runtime.Immutable

@Immutable
data class FoodCollection(
    val id: Long,
    val name: String,
    val snacks: List<FoodItem>,
    val type: CollectionType = CollectionType.Normal
)

enum class CollectionType { Normal, Highlight }

/*
* Fake Reposiroty
* */


object SnackRepo {

    fun getFoods(): List<FoodCollection> = snackCollections
    fun getFoodById(snackId: Long) = foodItems.find { item -> item.id == snackId }
    fun getFoodByRelated(@Suppress("UNUSED_PARAMETER") snackId: Long) = related
    fun getInspiredCart() = inspiredByCart
    fun getFilters() = filters
    fun getCart() = cart

}

private val tastyTreats = FoodCollection(
    id = 1L,
    name = "Foodie picks",
    type = CollectionType.Highlight,
    snacks = foodItems.subList(0, 13)
)

private val popular = FoodCollection(
    id = 2L,
    name = "Popular on Foodia",
    snacks = foodItems.subList(14,19)
)

private val wfhFavs =  tastyTreats.copy(
    id = 3L,
    name = "Favourites"
)

private val newlyAdd = popular.copy(
    id = 4L,
    name = "Newly Added"
)

private val exclusive = tastyTreats.copy(
    id = 5L,
    name = "Only on Foodia"
)

private val also = tastyTreats.copy(
    id = 6L,
    name = "Customers also bought"
)

private val inspiredByCart = tastyTreats.copy(
    id = 7L,
    name = "Inspired by your cart"
)

private val snackCollections = listOf(
    tastyTreats,
    popular,
    wfhFavs,
    newlyAdd,
    exclusive
)

private val related = listOf(
    also,
    popular
)

private val cart = listOf(
    OrderLine(foodItem = foodItems[4], count = 2),
    OrderLine(foodItem = foodItems[6], count = 3),
    OrderLine(foodItem = foodItems[8], count = 1)
)

@Immutable
data class OrderLine (
    val foodItem: FoodItem,
    val count: Int
)