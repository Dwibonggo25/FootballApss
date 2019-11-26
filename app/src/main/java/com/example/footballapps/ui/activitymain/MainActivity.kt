package com.example.footballapps.ui.activitymain

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.footballapps.R
import com.example.footballapps.databinding.ActivityMainBinding
import com.example.footballapps.ui.login.LoginViewModel
import com.google.android.material.navigation.NavigationView
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LoginViewModel
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        initBinding()

        navController  = Navigation.findNavController(this, R.id.main_nav_fragment)

        // Set up navigation menu
        bottomNavigationView.setupWithNavController(navController)

        val host = NavHostFragment.create(R.navigation.navigation)
        supportFragmentManager.beginTransaction().replace(R.id.main_nav_fragment, host).setPrimaryNavigationFragment(host).commit()
    }

    override fun onSupportNavigateUp(): Boolean = Navigation.findNavController(this, R.id.container).navigateUp()

    private fun initBinding() {
        viewModel = ViewModelProviders.of( this, viewModelFactory).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main)
        binding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}

