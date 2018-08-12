package com.example.seetha.funwithfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(), MainFragment.OnButtonClickedListener {

    private var detailFragment: DetailFragment? = null

    override fun onButtonClicked(view: View) {

        if (detailFragment == null) {
            startActivity(Intent(this, DetailActivity::class.java))
        }

        detailFragment?.let {

            if (!it.isVisible) {
                startActivity(Intent(this, DetailActivity::class.java))
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //configure and show MainFragment
        if (savedInstanceState == null) {
            val mainFragment = MainFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_layout_main, mainFragment)
                    .commit()
        }


        detailFragment = supportFragmentManager.findFragmentById(R.id.frame_layout_detail) as DetailFragment?

        //only add DetailFragment in Tablet mode (If found frame_layout_detail)
        if (detailFragment == null && findViewById<FrameLayout>(R.id.frame_layout_detail) != null) {
            detailFragment = DetailFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit()

        }

    }
}
