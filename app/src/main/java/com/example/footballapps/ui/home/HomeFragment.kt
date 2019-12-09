package com.example.footballapps.ui.home

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.footballapps.LEAGUES_DATA_FILENAME
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentHomeBinding
import com.example.footballapps.db.entity.Leagues
import com.example.footballapps.utils.NotificationHelper
import com.example.footballapps.vo.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewmodel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_home

    override fun getViewModelClass(): Class<HomeViewmodel> = HomeViewmodel::class.java

    private var CHANNEL_ID = "com.example.footballapps.ui.home"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var adapter: HomeRecyclerAdpater

    private lateinit var viewPager: ViewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NotificationHelper (context!!).createNotification()
        initRecyclerView()
        getDataAllSport()
        insertLeagues()
        createNotificationChannel()
        setHasOptionsMenu(true)
    }

    private fun getDataAllSport() {
        vm.sport.observe(this, Observer {data->
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
            val name = "Test"
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.searchMenu)
        val search : SearchView = searchItem.actionView as SearchView
        searchQuery(search)
    }

    private fun searchQuery(search: SearchView) {
        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
    }

    private fun insertLeagues() {
        context!!.assets.open(LEAGUES_DATA_FILENAME).use {
            JsonReader (it.reader()).use { jsonReader ->
                val legueType = object : TypeToken<List<Leagues>>() {}.type
                val foodList : List <Leagues> = Gson().fromJson(jsonReader, legueType)

                vm.insertLeague (foodList)
            }
        }
    }

    private fun initRecyclerView() {
        viewPager = binding.viewPagerBanner
        adapter = HomeRecyclerAdpater(ArrayList(), activity!!)
        viewPager.adapter = adapter
        //binding.tabLayout.setupWithViewPager(viewPager, true)
    }
}
