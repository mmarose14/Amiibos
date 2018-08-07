package com.amiibos.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.amiibos.R
import com.amiibos.model.Amiibo
import kotlinx.android.synthetic.main.activity_amiibo_detail.*

class AmiiboDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amiibo_detail)

        //Get the Amiibo details from passed intent data
        val amiiboDetails = intent.getSerializableExtra("EXTRA_AMIIBO") as Amiibo

        setupView(amiiboDetails)
    }

    //Display Amiibo details on the screen
    private fun setupView(amiiboDetails : Amiibo) {
        amiibo_name.text = amiiboDetails.name
        amiibo_series.text = amiiboDetails.amiiboSeries
        amiibo_release_date.text = amiiboDetails.release.na

    }
}
