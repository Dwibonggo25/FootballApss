package com.example.footballapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.footballapps.ui.login.LoginViewModel
import com.example.simplelogin.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel : LoginViewModel
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        initBinding ()

        val host = NavHostFragment.create(R.navigation.navigation)
        supportFragmentManager.beginTransaction().replace(R.id.main_nav_fragment, host).setPrimaryNavigationFragment(host).commit()

    }

    override fun onSupportNavigateUp(): Boolean = Navigation.findNavController(this, R.id.container).navigateUp()

    private fun initBinding() {
        viewModel = ViewModelProviders.of( this, viewModelFactory).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView ( this, R.layout.activity_main)
        binding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}

