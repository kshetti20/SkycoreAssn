package com.example.android.assignment.paging.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.savedstate.SavedStateRegistryOwner
import com.example.android.assignment.paging.vm.SearchRepositoriesViewModel
import com.example.android.assignment.paging.vm.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext


@InstallIn(ActivityComponent::class)
@Module
object ActivityScopeModule {

    @Provides
    fun getSavedInstanceStateOwner(@ActivityContext context: Context) =
        context as SavedStateRegistryOwner

    @Provides
    fun getViewModel(@ActivityContext context: Context, viewModelFactory: ViewModelFactory) =
        ViewModelProvider(context as ViewModelStoreOwner, viewModelFactory)
            .get(SearchRepositoriesViewModel::class.java)
}