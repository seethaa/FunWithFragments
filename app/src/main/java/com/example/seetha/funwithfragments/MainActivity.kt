package com.example.seetha.funwithfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent


class MainActivity : AppCompatActivity(), MainFragment.OnButtonClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClicked(view: View) {
//        Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, DetailActivity::class.java))

    }

}
