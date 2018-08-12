package com.example.seetha.funwithfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    lateinit var detailFragment: DetailFragment

    companion object {
       const val EXTRA_BUTTON_TAG = "detail_extra_button_tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //configure and show DetailFragment
        if (savedInstanceState == null) {
            detailFragment = DetailFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit()
        }
    }

    override fun onResume() {
        super.onResume()

        val buttonTag = intent.getIntExtra(EXTRA_BUTTON_TAG, 0)
        // Update DetailFragment's TextView
        detailFragment.updateTextView(buttonTag)

    }

}
