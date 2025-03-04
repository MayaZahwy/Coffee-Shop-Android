package com.example.coffe.Activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.coffe.Domain.ItemsModel
import com.example.coffe.Helper.ManagmentCart
import com.example.coffe.R
import com.example.coffe.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        managmentCart = ManagmentCart(this)
        bundle()
        initSizeList()
    }

    private fun initSizeList() {
        binding.apply {
            smallBtn.setOnClickListener {
                smallBtn.setBackgroundResource(R.drawable.stroke_black_bg)
                mediumBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(0)
            }

            mediumBtn.setOnClickListener {
                smallBtn.setBackgroundResource(0)
                mediumBtn.setBackgroundResource(R.drawable.stroke_black_bg)
                largeBtn.setBackgroundResource(0)
            }

            largeBtn.setOnClickListener {
                smallBtn.setBackgroundResource(0)
                mediumBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(R.drawable.stroke_black_bg)
            }
        }
    }

    private fun bundle() {
        binding.apply {
            item = intent.getSerializableExtra("object") as ItemsModel
            Glide.with(this@DetailActivity)
                .load(item.picUrl[0])
                .into(binding.picMain)
            titleTxt.text = item.title
            descriptionTxt.text = item.description
            priceTxt.text = "₪" + item.price
            ratingTxt.text = item.rating.toString()

            addToCartBtn.setOnClickListener {
                item.numberInCart = Integer.valueOf(numberItemTxt.text.toString())
                managmentCart.insertItems(item)

                // Show custom notification when item is added to cart
                showCustomNotification(binding.root)  // Only custom Snackbar is shown now
            }

            backBtn.setOnClickListener {
                finish()
            }

            plusCart.setOnClickListener {
                item.numberInCart++
                numberItemTxt.text = item.numberInCart.toString()
                updatePrice()
            }

            minusBtn.setOnClickListener {
                if (item.numberInCart > 1) {
                    item.numberInCart--
                    numberItemTxt.text = item.numberInCart.toString()
                    updatePrice()
                }
            }
        }
    }

    private fun updatePrice() {
        val totalPrice = item.numberInCart * item.price
        binding.priceTxt.text = "₪" + totalPrice
    }

    // Custom Snackbar example:
    private fun showCustomNotification(view: View) {
        val snackbar = Snackbar.make(view, "Added to your Cart", Snackbar.LENGTH_SHORT)

        // Customize background and icon (if needed)
        val customSnackbarView = snackbar.view
        customSnackbarView.setBackgroundColor(Color.parseColor("#4CAF50"))

        // Optionally add an icon:
        val icon = resources.getDrawable(R.drawable.btn_2, theme)  // Customize with your own icon
        val snackbarText = customSnackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        snackbarText.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
        snackbarText.setTextColor(Color.WHITE)  // Text color
        snackbarText.compoundDrawablePadding = 16  // Padding between icon and text

        snackbar.show()
    }
}
