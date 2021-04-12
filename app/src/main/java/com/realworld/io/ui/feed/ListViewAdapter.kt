package com.realworld.io.ui.feed

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.realworld.api.models.objects.Article
import com.realworld.io.databinding.ListItemViewBinding

class ListViewAdapter(val clickListener: ArticleListener) : androidx.recyclerview.widget.ListAdapter<Article, ListViewAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(val binding: ListItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, clickListener: ArticleListener){
            binding.tvAuthorName.text = article.author.username
            binding.tvBody.text = article.body
            binding.tvTitle.text = article.title
            binding.tvDate.text = article.createdAt
            binding.article = article
            binding.clickListener = clickListener
            binding.executePendingBindings()


        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemViewBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = getItem(position)

        holder.bind(article, clickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


}


class DiffCallback: DiffUtil.ItemCallback<Article>(){
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

}

class ArticleListener(val clickListener: (articleSlug:String?) -> Unit) {

    fun onClick(article: Article?) = clickListener(article?.slug)
}