package com.example.footballapps.di.module

import com.example.footballapps.ui.allmatch.AllMatchFragment
import com.example.footballapps.ui.home.HomeFragment
import com.example.footballapps.ui.login.LoginFragment
import com.example.footballapps.ui.matchinfo.MatchInfoFragment
import com.example.footballapps.ui.nextmatch.NextMatchFragment
import com.example.footballapps.ui.scores.ScoresFragment
import com.example.footballapps.ui.splashscreen.SplashScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributesSplashScreenFragment(): SplashScreenFragment

    @ContributesAndroidInjector
    abstract fun contributesSplashHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesMatchInfoFragment(): MatchInfoFragment

    @ContributesAndroidInjector
    abstract fun contributesNextMatchFragment(): NextMatchFragment

    @ContributesAndroidInjector
    abstract fun contributesScoresFragment(): ScoresFragment

    @ContributesAndroidInjector
    abstract fun contributesAllMatchFragment(): AllMatchFragment
}