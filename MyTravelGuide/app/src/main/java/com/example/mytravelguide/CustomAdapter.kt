package com.androdocs.populatelistview


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mytravelguide.City
import com.example.mytravelguide.CityInformation
import com.example.mytravelguide.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_row.view.*


class CustomAdapter(private val context: Context,
                    private val dataList: ArrayList<City>) : BaseAdapter() {

    private val inflater: LayoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int { return dataList.size }
    override fun getItem(position: Int): Int { return position }
    override fun getItemId(position: Int): Long { return position.toLong() }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var dataitem = dataList[position]

        val rowView = inflater.inflate(R.layout.list_row, parent, false)
        var city = dataitem.city
        var hotel = dataitem.hotel
        rowView.findViewById<TextView>(R.id.cityName).text = city
        rowView.findViewById<TextView>(R.id.hotelRateo).text = hotel
        rowView.row_image.setOnClickListener {

            val intent = Intent(context,CityInformation::class.java)
            intent.putExtra("hotel",hotel!!)
            intent.putExtra("image",dataitem.image!!)

            context!!.startActivity(intent)
        }

        rowView.row_image.setImageResource(dataitem.image!!)

        rowView.tag = position
        return rowView
    }
}