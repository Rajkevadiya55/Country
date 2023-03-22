package com.example.country

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class CountryAdapter(list: List<CountryModel>?, CountryClick: CountryClick) : RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    lateinit var context: Context
    var CountryClick=CountryClick
    var list=list


    class CountryHolder(itemView: View):ViewHolder(itemView) {

        var img=itemView.findViewById<ImageView>(R.id.image)
        var country=itemView.findViewById<TextView>(R.id.txtCountry)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {

        context=parent.context
        return CountryHolder(LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return list?.size!!

    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        Glide.with(context).load(list?.get(position)?.flags ?.png).into(holder.img)
        holder.country.text=list?.get(position)?.name


        holder.itemView.setOnClickListener {

            CountryClick.onTap(position)
        }



        }
    }


//private val apiInterface: ApiInterface