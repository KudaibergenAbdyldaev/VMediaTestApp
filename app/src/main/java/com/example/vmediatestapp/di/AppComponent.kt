package com.example.vmediatestapp.di

import android.app.Application
import com.example.vmediatestapp.presentation.App
import com.example.vmediatestapp.presentation.MainActivity
import com.example.vmediatestapp.presentation.main_fragment.MainFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)
    fun inject(activity: MainActivity)
    fun inject(mainFragment: MainFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }

}