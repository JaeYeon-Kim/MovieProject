package com.kjy.movieproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.kjy.movieproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 프래그먼트 이동을 위한 함수
        initBottomNavigation()

        setSupportActionBar(binding.mainLayoutToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.top_menu)
        supportActionBar?.setDisplayShowTitleEnabled(false)//    타이틀 안보이게하기
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.END)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    // 프래그먼트 이동을 위한 함수
    private fun initBottomNavigation() {
        // 트랜잭션 시작
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, HomeFragment())
            .commitAllowingStateLoss()

        // 바텀 네비게이션 각 id에 맞는 아이템 클릭시 이벤트
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.store -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, StoreFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.reserve -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, ReserveFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mobile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, MobileFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.my -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, MyFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    Toast.makeText(this, "오류 발생!!", Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
            }

        }
    }

}