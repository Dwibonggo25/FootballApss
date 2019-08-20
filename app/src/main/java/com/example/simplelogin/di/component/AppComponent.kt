package com.example.simplelogin.di.component

import com.example.simplelogin.SimpleApp
import com.example.simplelogin.di.module.AppModule
import com.example.simplelogin.di.module.BuilderModule
import com.example.simplelogin.di.module.RepositoryModule
import com.example.simplelogin.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, BuilderModule::class, AppModule::class, RepositoryModule::class, ViewModelModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SimpleApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: SimpleApp)
}