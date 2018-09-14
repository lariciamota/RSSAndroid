package br.ufpe.cin.if710.rss

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.textView
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle


class RecyclerCustomAdapter(private val items: List<ItemRSS>) : RecyclerView.Adapter<RecyclerCustomAdapter.MyViewHolder>()  {
    class MyViewHolder(val view: LinearLayout) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCustomAdapter.MyViewHolder {
        val linearLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.itemlista, parent, false)  as LinearLayout
        return MyViewHolder(linearLayout)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerCustomAdapter.MyViewHolder, position: Int) {
        var txtViewTitle: TextView = holder.view.getChildAt(0) as TextView
        var txtViewDate: TextView = holder.view.getChildAt(1) as TextView
        txtViewTitle.text = items[position].title
        txtViewTitle.setOnClickListener {
            web_page_open(items[position].link, holder.view.context)
        }
        txtViewDate.text = items[position].pubDate
    }

    fun web_page_open(urls: String, mContext : Context) {
        val webpage = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, webpage)
        mContext.startActivity(intents)
    }

}

