package com.example.android.assignment.paging.ui.ui_controllers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.android.assignment.paging.R
import com.example.android.assignment.paging.model.BusinessData
import javax.inject.Inject

/**
 * Adapter for the list of repositories.
 */
class ReposAdapter @Inject constructor() : PagingDataAdapter<BusinessData, RepoViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.business_item_layout, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            holder.bind(repoItem)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<BusinessData>() {
            override fun areItemsTheSame(oldItem: BusinessData, newItem: BusinessData): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: BusinessData, newItem: BusinessData): Boolean =
                oldItem == newItem
        }
    }
}
