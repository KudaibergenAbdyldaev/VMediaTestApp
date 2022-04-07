package com.example.vmediatestapp.di

import androidx.lifecycle.ViewModel
import com.example.vmediatestapp.presentation.main_fragment.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}