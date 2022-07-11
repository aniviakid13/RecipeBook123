package com.codefresher.recipebook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codefresher.recipebook.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
//        navController = navHostFragment.navController
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        setupWithNavController(bottomNavigationView, navController)

        val homeFragment = HomeFragment()
        val createFragment = CreateFragment()
        val tagFragment = TagFragment()
        val profileFragment = ProfileFragment()
        val favoriteFragment = FavoriteFragment()

        makeCurrentFragment(homeFragment)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> makeCurrentFragment(homeFragment)
                R.id.itemCreate -> makeCurrentFragment(createFragment)
                R.id.itemTag -> makeCurrentFragment(tagFragment)
                R.id.itemProfile -> makeCurrentFragment(profileFragment)
                R.id.itemFavorite -> makeCurrentFragment(favoriteFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainContainer, fragment)
            commit()

        }
    }

}