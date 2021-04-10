package com.realworld.io.ui.feed

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.realworld.api.models.objects.Article
import com.realworld.io.R
import com.realworld.io.databinding.FragmentGlobalFeedBinding
import com.realworld.io.databinding.ListItemViewBinding

class ListViewAdapter() : RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    var articles = listOf<Article>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ViewHolder(val view:View) : RecyclerView.ViewHolder(view) {
        val tvAuthor = view.findViewById<TextView>(R.id.tv_author_name)
        val tv_body = view.findViewById<TextView>(R.id.tv_body)
        val tv_title = view.findViewById<TextView>(R.id.tv_title)
        val tv_date = view.findViewById<TextView>(R.id.tv_date)
        val iv_profile_img = view.findViewById<ImageView>(R.id.iv_image)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]

        holder.tvAuthor.text = article.author.username
        holder.tv_body.text = article.body
        holder.tv_title.text = article.title
        holder.tv_date.text = article.createdAt
        holder.iv_profile_img.setImageURI(Uri.parse(article.author.image))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_view,parent,false)
        return ViewHolder(view)
    }
}