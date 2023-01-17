package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.CartItem
import com.ddd_bootcamp.domain.Price
import com.ddd_bootcamp.domain.Product

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val cart1 = Cart()
        val cart2 = Cart()
        val priceHeadphone = Price(10.0)
        val headphone = CartItem(
            quantity = 1,
            product = Product(
                name = "Sony Wireless headphone",
                price = priceHeadphone,
            ),
        )
        cart1.add(headphone)
        cart2.add(headphone)
        cart1.print("Cart1")
        cart2.print("Cart2")
        println("Are cart1 & cart2 the same? ${cart1 == cart2}")
    }
}

private fun Cart.print(cartName: String) {
    println("----------------------------------------")
    println("----------------- $cartName ----------------")
    println("----------------------------------------")
    println("Cart = $this")
    val cartItems = this.items.joinToString("\n\t") { it.toString() }
    val removedCartItems = this.removedItems.joinToString("\n\t") { it.toString() }
    println("----------------------------------------")
    println("Cart Items = \n$cartItems")
    println("----------------------------------------")
    println("Removed Cart Items = \n$removedCartItems")
    println("----------------------------------------")
    println("----------------------------------------")
    println("----------------- $cartName End ------------")
    println("----------------------------------------")
}
