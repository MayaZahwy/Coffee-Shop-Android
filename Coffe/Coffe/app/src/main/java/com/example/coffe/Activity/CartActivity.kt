package com.example.coffe.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffe.Adapter.CartAdapter
import com.example.coffe.ChangeNumberItemsListener
import com.example.coffe.Helper.ManagmentCart
import com.example.coffe.R
import com.example.coffe.databinding.ActivityCartBinding
import com.example.coffe.databinding.ViewholderCartBinding

class CartActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    lateinit var managmentCart: ManagmentCart
    private var tax: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        calculateCart()
        setVariable()
        initCartList()

        // Add this code here for the "Proceed to Checkout" button click listener
        binding.button3.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initCartList() {
        binding.apply {
            cartView.layoutManager = LinearLayoutManager(this@CartActivity, LinearLayoutManager.VERTICAL, false)
            cartView.adapter = CartAdapter(
                managmentCart.getListCart(),
                this@CartActivity,
                object : ChangeNumberItemsListener{
                    override fun onChanged() {
                        calculateCart()
                    }
                }
            )
        }
    }

    private fun setVariable() {
        binding.backBtn.setOnClickListener { finish() }
    }

    private fun calculateCart() {
        val percentTax = 0.17
        val delivery = 10
        val totalFee = managmentCart.getTotalFee()

        // Check if the cart is empty
        if (totalFee > 0) {
            tax = Math.round((totalFee * percentTax) * 100) / 100.0
            val total = Math.round((totalFee + tax + delivery) * 100) / 100
            val itemTotal = Math.round(totalFee * 100) / 100

            // Update the UI with the calculated values
            binding.apply {
                totalFeeTxt.text = "₪$itemTotal"
                taxTxt.text = "₪$tax"
                deliveryTxt.text = "₪$delivery"
                totalTxt.text = "₪$total"
            }
        } else {
            // If the cart is empty, set all fees to 0 and hide them
            binding.apply {
                totalFeeTxt.text = "₪0.0"
                taxTxt.text = "₪0.0"
                deliveryTxt.text = "₪0.0"
                totalTxt.text = "₪0.0"
            }
        }
    }
}
