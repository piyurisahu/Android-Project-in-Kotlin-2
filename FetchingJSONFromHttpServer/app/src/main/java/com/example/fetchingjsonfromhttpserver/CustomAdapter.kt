package com.example.fetchingjsonfromhttpserver

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.security.AccessControlContext

class CustomAdapter(private  val context: Context, private val dataList: ArrayList<HashMap<String, String>>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}