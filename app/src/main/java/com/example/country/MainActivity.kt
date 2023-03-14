package com.example.country

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.country.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var countryList=java.util.ArrayList<CountryModel>()
    lateinit var adapter: CountryAdapter
    private val TAG="MainActivity"


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


     var apiInterface=ApiClient.getApiClient().create(ApiInterface::class.java)

        apiInterface.getAllCountry().enqueue(object :Callback<List<CountryModel>?>{
            override fun onResponse(
                call: Call<List<CountryModel>?>,
                response: Response<List<CountryModel>?>
            ) {

                if (response.isSuccessful){
                    countryList= response.body() as ArrayList<CountryModel>
                    adapter= CountryAdapter(countryList)
                    binding.Recycle.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding.Recycle.adapter=adapter
                    Log.e(TAG,"onResponse Done")

                }else {

                    Log.e(TAG,"onResponse failed")
                }
            }

            override fun onFailure(call: Call<List<CountryModel>?>, t: Throwable) {

            }

        })

    }
}

