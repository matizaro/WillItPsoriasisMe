package com.example.myapplication.main

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.myapplication.R
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class MainActivityVM(val navController: NavController) : ViewModel(){

    fun bottomBarNavigation(menuItemId: Int): Boolean {
        when(menuItemId){
//            R.id.menu_search -> //TODO
//            R.id.menu_last_searched -> //TODO
//            R.id.menu_notifications -> //TODO
//            else -> //TODO
        }
        return true
    }

    companion object{
        val mainActivityModule = module {
            factory { (activity: Activity) -> findNavController(activity, R.id.navigationHostFragment) }
            viewModel { MainActivityVM(get()) }
        }
    }
}