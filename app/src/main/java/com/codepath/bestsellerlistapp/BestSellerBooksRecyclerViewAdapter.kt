package com.codepath.bestsellerlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.codepath.bestsellerlistapp.BestSellerBooksRecyclerViewAdapter.BookViewHolder
import com.codepath.bestsellerlistapp.models.BestSellerBook
import kotlinx.android.synthetic.main.fragment_best_seller_books.view.*

/**
 * [RecyclerView.Adapter] that can display a [BestSellerBook] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class BestSellerBooksRecyclerViewAdapter(
        private val books: List<BestSellerBook>,
        private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_best_seller_books, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.mItem = books[position]
        holder.mBookTitle.text = books[position].title
        holder.mBookAuthor.text = books[position].author
        holder.mBookRank.text = books[position].rank.toString()
        holder.mBookDescription.text = books[position].description
        Glide.with(holder.mView)
                .load(books[position].bookImageUrl)
                .centerInside()
                .into(holder.mBookImage);
        holder.mView.setOnClickListener {
            mListener?.onItemClick(holder.mItem)
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }

    inner class BookViewHolder(val mView: View) : ViewHolder(mView) {
        val mBookTitle: TextView = mView.book_title
        val mBookAuthor: TextView = mView.book_author
        val mBookRank: TextView = mView.ranking
        val mBookDescription: TextView = mView.book_description
        val mBookImage: ImageView = mView.book_image
        lateinit var mItem: BestSellerBook

        override fun toString(): String {
            return mBookTitle.toString() + " '" + mBookAuthor.text + "'"
        }
    }
}