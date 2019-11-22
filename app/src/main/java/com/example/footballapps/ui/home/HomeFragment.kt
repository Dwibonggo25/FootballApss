package com.example.footballapps.ui.home

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.footballapps.R
import com.example.footballapps.databinding.FragmentHomeBinding
import com.example.footballapps.utils.NotificationHelper
import com.example.footballapps.utils.sendNotification
import com.example.footballapps.vo.Result
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class HomeFragment : Fragment() {

    private var CHANNEL_ID = "com.example.footballapps.ui.home"

    private lateinit var viewModel: HomeViewmodel

    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var adapter: HomeRecyclerAdpater

    private lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel= ViewModelProviders.of(this, viewModelFactory).get(HomeViewmodel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {
            binding.vm = viewModel
            binding.setLifecycleOwner(activity)
            binding.executePendingBindings()
        }

        createNotificationChannel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NotificationHelper (context!!).createNotification()
        initRecyclerView()

        viewModel.sport.observe(this, Observer {data->
            data?.let {
                when (it.status){
                    Result.Status.SUCCESS -> {
                        binding.cvLoadingInformation.hideLoading()
                        adapter.refresh(it.data!!)
                    }
                    Result.Status.LOADING -> {
                        binding.cvLoadingInformation.showLoading()
                    }
                    Result.Status.ERROR -> {
                        binding.cvLoadingInformation.showErrorMessage()
                    }
                }
            }
        })
    }

    private fun createNotificationChannel () {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Bacot"
            val description = "Test"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = requireActivity().getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }

    private fun initRecyclerView() {
        viewPager = binding.viewPagerBanner
        adapter = HomeRecyclerAdpater(ArrayList(), activity!!)
        viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(viewPager, true)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
