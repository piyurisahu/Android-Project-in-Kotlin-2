package com.androdocs.populatelistview


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mytravelguide.CityInformation
import com.example.mytravelguide.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_row.view.*


class CustomAdapter(private val context: Context,
                    private val dataList: ArrayList<HashMap<String, String>>) : BaseAdapter() {

    private val inflater: LayoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int { return dataList.size }
    override fun getItem(position: Int): Int { return position }
    override fun getItemId(position: Int): Long { return position.toLong() }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var dataitem = dataList[position]

        val rowView = inflater.inflate(R.layout.list_row, parent, false)
        rowView.findViewById<TextView>(R.id.row_name).text = dataitem.get("name")
        rowView.findViewById<TextView>(R.id.row_age).text = dataitem.get("age")
        rowView.findViewById<TextView>(R.id.row_city).text = dataitem.get("city")
//        rowView.row_image.setImageResource(animal.image!!)
        rowView.row_image.setOnClickListener {

            val intent = Intent(context,CityInformation::class.java)
            intent.putExtra("name",dataitem.get("name")!!)
            intent.putExtra("age",dataitem.get("age")!!)
            intent.putExtra("image",dataitem.get("city")!!)

            context!!.startActivity(intent)


        }

        Picasso.get()
            .load(dataitem.get("image"))
            .resize(50, 50)
            .centerCrop()
            .into(rowView.findViewById<ImageView>(R.id.row_image))

        rowView.tag = position
        return rowView
    }
}