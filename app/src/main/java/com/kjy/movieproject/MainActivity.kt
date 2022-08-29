package com.kjy.movieproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
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
        supportActionBar?.setDisplayShowTitleEnabled(false)//    타이틀 안보이게하기
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.barcode)
    }

    // 툴바 만듬
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 툴바 아이콘 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            // 드로어 메뉴 버튼
            R.id.login -> {
                binding.drawerLayout.openDrawer(GravityCompat.END)
                return true
            }
            // 피드로고 버튼
            R.id.feedLogo -> {
                return true
            }
            // 바코드 버튼
            android.R.id.home -> {

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
            binding.toolbarTextTitle.visibility = View.GONE

        // 바텀 네비게이션 각 id에 맞는 아이템 클릭시 이벤트
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, HomeFragment())
                        .commitAllowingStateLoss()
                        with(binding) {
                            toolbarTextTitle.visibility = View.GONE
                            toolbarTitle.visibility = View.VISIBLE
                            mainLayoutToolbar.setBackgroundColor(Color.parseColor("#110C2D"))
                        }
                    return@setOnItemSelectedListener true
                }

                R.id.store -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, StoreFragment())
                        .commitAllowingStateLoss()
                    with(binding) {
                        toolbarTitle.visibility = View.GONE
                        toolbarTextTitle.visibility = View.VISIBLE
                        toolbarTextTitle.text = "스토어"
                        mainLayoutToolbar.setBackgroundColor(Color.parseColor("#110C2D"))
                    }

                    return@setOnItemSelectedListener true
                }

                R.id.reserve -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, ReserveFragment())
                        .commitAllowingStateLoss()
                    with(binding) {
                        toolbarTitle.visibility = View.GONE
                        toolbarTextTitle.visibility = View.VISIBLE
                        toolbarTextTitle.text = "예매"
                        mainLayoutToolbar.setBackgroundColor(Color.parseColor("#110C2D"))
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.mobile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, MobileFragment())
                        .commitAllowingStateLoss()
                    with(binding) {
                        toolbarTitle.visibility = View.GONE
                        toolbarTextTitle.visibility = View.VISIBLE
                        toolbarTextTitle.text = "모바일오더"
                        mainLayoutToolbar.setBackgroundColor(Color.parseColor("#E2B056"))
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.my -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, MyFragment())
                        .commitAllowingStateLoss()
                    with(binding) {
                        toolbarTitle.visibility = View.GONE
                        toolbarTextTitle.visibility = View.VISIBLE
                        toolbarTextTitle.text = "나의 메가박스"
                        mainLayoutToolbar.setBackgroundColor(Color.parseColor("#110C2D"))
                    }
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