package com.project.samplefooddelivery.ui.activity.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.project.samplefooddelivery.R
import com.project.samplefooddelivery.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var bottomSheetBehavior: BottomSheetBehavior<View>


    lateinit var homeBinding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        init()

    }

    private fun init() {

        setUpToolbar()

        homeBinding.layoutContainHomepage.navViewHomeBottom.setNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.menu_home_bar_search -> {
                    showToast("Search Clicked")
                }

                R.id.menu_home_bar_help -> showToast("Dashboard Clicked")

                R.id.menu_home_bar_help_support -> showToast("3D Clicked")

                R.id.menu_home_bar_help_cancel -> showToast("Accelerator Clicked")
            }
            true
        }

        bottomSheetBehavior =
            BottomSheetBehavior.from(homeBinding.layoutContainHomepage.frameLayouHomeBottom)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        homeBinding.layoutContainHomepage.homeAppBar.let {
            with(homeBinding.layoutContainHomepage.homeAppBar) {
                setNavigationIcon(R.drawable.ic_menu)
                replaceMenu(R.menu.menu_home_app_bar)
                setNavigationOnClickListener {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
                }
                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.menu_home_bar_search -> {
                            showToast("Search Clicked")
                        }

                        R.id.menu_home_bar_help -> showToast("Dashboard Clicked")

                        R.id.menu_home_bar_help_support -> showToast("3D Clicked")

                        R.id.menu_home_bar_help_cancel -> showToast("Accelerator Clicked")
                    }
                    false
                }

                setOnClickListener {
                    showToast("Fab Clicked..")
                }

            }
        }


        /*Swipe Refresh*/

//            homeBinding.layoutContainHomepage.includeHomeItems.setOnRefreshListener {
//
//                homeBinding.layoutContainHomepage.includeHomeItems.isRefreshing = false
//
//            }


        val swipe_refresh_home = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_home);
        swipe_refresh_home.setOnRefreshListener {
            swipe_refresh_home.isRefreshing = false
        }

    }

    private fun setUpToolbar() {
        supportActionBar?.let { tb ->
            tb.title = "with fab"
            tb.setHomeButtonEnabled(true)
            tb.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_HIDDEN) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            return
        }
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}