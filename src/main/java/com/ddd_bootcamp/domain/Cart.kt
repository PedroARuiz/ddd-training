package com.ddd_bootcamp.domain

import java.util.UUID

class Cart {
    val id = UUID.randomUUID()
    val cartItems: MutableList<CartItem> = ArrayList()
    private val removedCartItems: MutableList<CartItem> = ArrayList()

    fun add(cartItem: CartItem) {
        cartItems.add(cartItem)
    }

    fun remove(cartItemName: String) {
        cartItems.filter { it.product.name == cartItemName }.also {
            removedCartItems.addAll(it)
            cartItems.removeAll(it)
        }
    }

    val items: List<CartItem>
        get() = cartItems

    val removedItems: List<CartItem>
        get() = removedCartItems

    val removedProductNames get(): List<String> = removedItems.map { it.product.name }

    override fun toString(): String {
        return "Cart{" +
                "cartItems=" + cartItems +
                "; removedCartItems=" + removedCartItems +
                '}'
    }

    override fun equals(other: Any?): Boolean = other is Cart &&
            other.id == this.id

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + cartItems.hashCode()
        result = 31 * result + removedCartItems.hashCode()
        return result
    }
}