package com.amiibos.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.amiibos.R
import com.amiibos.model.Amiibo
import com.amiibos.model.AmiiboResponse
import com.amiibos.service.AmiiboService
import com.amiibos.view.AmiibosAdapter
import kotlinx.android.synthetic.main.activity_amiibos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AmiibosActivity : AppCompatActivity(), AmiiboClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amiibos)

        getAmiibos()

    }

    //Call the Amiibo API and get the list of "figures"
    private fun getAmiibos() {

        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.amiiboapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val amiiboServiceApi = retrofit.create(AmiiboService::class.java)

        amiiboServiceApi.getAmiibos().enqueue(object : Callback<AmiiboResponse> {
            override fun onResponse(call: Call<AmiiboResponse>?, response: Response<AmiiboResponse>?) {
                if (response != null && response.isSuccessful) {
                    setupView(response.body()!!.amiibo)
                } else {
                    displayError("There was a problem retrieving the Amiibos")
                }
            }

            override fun onFailure(call: Call<AmiiboResponse>?, t: Throwable?) {
                Log.d("Service failure", t.toString())
                displayError("There was a problem retrieving the Amiibos")
            }
        })
    }

    //Displays a user friendly error in case the API call fails
    private fun displayError(message : String) {
        error_message.visibility = View.VISIBLE
        error_message.text = message
    }

    //Sets up the view with the RecyclerAdapter and loads the Amiibo data when returned
    private fun setupView(amiibo: List<Amiibo>?) {
        error_message.visibility = View.INVISIBLE
        amiibos_list.layoutManager = LinearLayoutManager(this)
        amiibos_list.adapter = AmiibosAdapter(amiibo!!, this, this)
    }

    //Pass the selected Amiibo details the the Details screen
    override fun onClickListener(amiibo: Amiibo) {
        val intent = Intent(this, AmiiboDetailActivity::class.java)
        intent.putExtra("EXTRA_AMIIBO", amiibo)
        startActivity(intent)
    }
}

interface AmiiboClickListener {
    fun onClickListener(amiibo: Amiibo)
}