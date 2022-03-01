package com.example.android.assignment.paging.ui.ui_controllers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.assignment.paging.R
import com.example.android.assignment.paging.model.BusinessData

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    private val name: TextView = view.findViewById(R.id.repo_name)
//    private val description: TextView = view.findViewById(R.id.repo_description)
//    private val stars: TextView = view.findViewById(R.id.repo_stars)
//    private val language: TextView = view.findViewById(R.id.repo_language)
//    private val forks: TextView = view.findViewById(R.id.repo_forks)


        private val business_icon: ImageView = view.findViewById(R.id.business_icon)
        private val business_rating: TextView = view.findViewById(R.id.business_rating)
        private val business_name: TextView = view.findViewById(R.id.business_name)
        private val business_loc: TextView = view.findViewById(R.id.business_loc)
        private val business_status: TextView = view.findViewById(R.id.business_status)



    private var repo: BusinessData? = null

    fun bind(repo: BusinessData?) {
        if (repo == null) {
            val resources = itemView.resources
            business_name.text = resources.getString(R.string.loading)
            business_loc.visibility = View.GONE
            business_status.visibility = View.GONE
            business_icon.visibility = View.GONE
            business_rating.visibility = View.GONE
        } else {
            showRepoData(repo)
        }
    }

    private fun showRepoData(repo: BusinessData) {
        this.repo = repo
        business_name.text = repo.name
        val loc = "${repo.distance.toInt()}m ${repo.location.address1}, ${repo.location.city}"
        business_loc.text = loc
        business_rating.text = "${repo.rating}"
        business_status.text = if(!repo.is_closed) "Currently Open" else "Currently Closed"
    }
}
