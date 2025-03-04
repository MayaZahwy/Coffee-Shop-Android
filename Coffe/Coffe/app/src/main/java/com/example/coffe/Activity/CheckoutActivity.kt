package com.example.coffe.Activity

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffe.R

class CheckoutActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var confirmCheckoutBtn: Button
    private lateinit var deliveryMessageTxt: TextView
    private lateinit var motorcycleImageView: android.widget.ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        emailEditText = findViewById(R.id.emailEditText)
        confirmCheckoutBtn = findViewById(R.id.confirmCheckoutBtn)
        deliveryMessageTxt = findViewById(R.id.deliveryMessageTxt)
        motorcycleImageView = findViewById(R.id.motorcycleImageView)

        confirmCheckoutBtn.setOnClickListener {
            val email = emailEditText.text.toString()

            if (email.isNotEmpty()) {
                // Just show a delivery message without sending an email
                sendDeliveryMessage(email)
                // Start the motorcycle animation
                startMotorcycleAnimation()
            } else {
                Toast.makeText(this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Method to show a delivery message
    private fun sendDeliveryMessage(email: String) {
        val deliveryMessage = "Your order is on the way"
        deliveryMessageTxt.text = deliveryMessage
    }

    // Start the motorcycle animation
    private fun startMotorcycleAnimation() {
        // Create the translate animation
        val animation = TranslateAnimation(
            Animation.RELATIVE_TO_PARENT, 0f, // Start from the left
            Animation.RELATIVE_TO_PARENT, 1f, // Move to the right
            Animation.RELATIVE_TO_PARENT, 0f, // Start from the original position
            Animation.RELATIVE_TO_PARENT, 0f  // Keep it vertically in the same position
        )
        animation.duration = 5000 // Duration of 5 seconds (you can adjust this)
        animation.repeatCount = Animation.INFINITE // Repeat animation indefinitely
        animation.repeatMode = Animation.RESTART // Restart the animation after it completes

        // Start the animation on the motorcycle image
        motorcycleImageView.startAnimation(animation)
    }
}
