package com.beatrix.debug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.beatrix.debug.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        expenses_amount.text = getIntent().getStringExtra("AMOUNT")
        category_name.text = getIntent().getStringExtra("CATEGORY")
        expenses_description.text = getIntent().getStringExtra("DESCRIPTION")
        getIntent().getStringExtra("CATEGLOGO")?.let { category_image.setImageResource(it.toInt()) }
    }
}