package com.example.footballapps.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.footballapps.ui.login.LoginViewModel
import com.example.footballapps.di.ViewModelFactory
import com.example.footballapps.di.ViewModelKey
import com.example.footballapps.ui.allmatch.AllMatchViewmodel
import com.example.footballapps.ui.detailmatch.DetailMatchViewmodel
import com.example.footballapps.ui.favorite.FavoriteViewmodel
import com.example.footballapps.ui.home.HomeViewmodel
import com.example.footballapps.ui.listsports.ListSportsViewModel
import com.example.footballapps.ui.matchinfo.MatchInfoViewmodel
import com.example.footballapps.ui.nextmatch.NextMatchViewmodel
import com.example.footballapps.ui.scores.ScoresViewmodel
import com.example.footballapps.ui.splashscreen.SplashScreenViewmodel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun providesLoginViewModel(viewModel : LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewmodel::class)
    internal abstract fun providesSplashScreenViewmodel(viewModel : SplashScreenViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewmodel::class)
    internal abstract fun providesSplashHomeViewmodel(viewModel : HomeViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MatchInfoViewmodel::class)
    internal abstract fun providesMatchInfoViewmodel(viewModel : MatchInfoViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NextMatchViewmodel::class)
    internal abstract fun providesNextMatchViewmodel(viewModel : NextMatchViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScoresViewmodel::class)
    internal abstract fun providesScoresViewmodel(viewModel : ScoresViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllMatchViewmodel::class)
    internal abstract fun providesAllMatchViewmodel(viewModel : AllMatchViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewmodel::class)
    internal abstract fun providesFavoriteViewmodel(viewModel : FavoriteViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailMatchViewmodel::class)
    internal abstract fun providesDetailMatchViewmodel(viewModel : DetailMatchViewmodel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( ListSportsViewModel::class)
    internal abstract fun providesListSportsViewModel(viewModel : ListSportsViewModel) : ViewModel
}