package com.example.seetha.funwithfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.FrameLayout
import com.example.seetha.funwithfragments.DetailActivity.Companion.EXTRA_BUTTON_TAG
import kotlinx.android.synthetic.main.fragment_detail.*

class MainActivity : AppCompatActivity(), MainFragment.OnButtonClickedListener {

    private var detailFragment: DetailFragment? = null

    override fun onButtonClicked(view: View) {

        val buttonTag = Integer.parseInt(view.tag.toString())
        detailFragment?.let {

            if (it.isVisible) {
                it.updateTextView(buttonTag)
            }
        } ?: goToDetailActivity(buttonTag)

    }

    private fun goToDetailActivity(buttonTag: Int) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra(EXTRA_BUTTON_TAG, buttonTag)
        startActivity(i)
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
