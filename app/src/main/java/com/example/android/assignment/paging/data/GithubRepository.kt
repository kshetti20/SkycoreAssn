package com.example.android.assignment.paging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android.assignment.paging.api.ApiService
import com.example.android.assignment.paging.model.BusinessData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Repository class that works with local and remote data sources.
 */
class GithubRepository @Inject constructor(private val service: ApiService) {

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */
    fun getSearchResultStream(
        location: String,
        radius: String
    ): Flow<PagingData<BusinessData>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { GithubPagingSource(service, location, radius) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 15
    }
}
