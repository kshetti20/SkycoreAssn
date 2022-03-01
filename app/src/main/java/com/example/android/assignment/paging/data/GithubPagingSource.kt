package com.example.android.assignment.paging.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android.assignment.paging.api.ApiService
import com.example.android.assignment.paging.model.BusinessData
import retrofit2.HttpException
import java.io.IOException

private const val DEFAULT_PAGE_INDEX_OFFSET = 0

class GithubPagingSource(
    private val service: ApiService,
    private val location: String,

    private val radius: String
) : PagingSource<Int, BusinessData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BusinessData> {
        val position = params.key ?: DEFAULT_PAGE_INDEX_OFFSET

        return try {

            val api_key =
                "Bearer XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"

            val response =
                service.searchBusinesses(api_key, location, radius, offset = position.toString())

            val repos = response.items
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                position + response.items.size
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (position == DEFAULT_PAGE_INDEX_OFFSET) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, BusinessData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
