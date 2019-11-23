package com.example.myapplication.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    private val navFragment: NavController by inject()
    private val mainActivityVM: MainActivityVM by inject()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        activityMainBottomNavigationView.setOnNavigationItemSelectedListener{ mainActivityVM.bottomBarNavigation(it.itemId) }
    }
}

