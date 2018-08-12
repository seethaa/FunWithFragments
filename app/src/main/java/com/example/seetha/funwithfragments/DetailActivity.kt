package com.example.seetha.funwithfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //configure and show DetailFragment
        if (savedInstanceState == null) {
            val detailFragment = DetailFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit()
        }
    }

}
