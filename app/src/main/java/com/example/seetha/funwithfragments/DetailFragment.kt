package com.example.seetha.funwithfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.*


/**
 * A simple [Fragment] subclass.
 *
 */
class DetailFragment : Fragment() {

    private var buttonTag = 0

    companion object {
        const val KEY_BUTTONTAG = "detailfragment_button_tag"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // restore last buttonTag if possible
        savedInstanceState?.let {
            val buttonTagRestored = savedInstanceState.getInt(KEY_BUTTONTAG, 0)
            // Update TextView
            this.updateTextView(buttonTagRestored)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_BUTTONTAG, buttonTag)
    }

    fun updateTextView(buttonTag: Int) {

        this.buttonTag = buttonTag

        when (buttonTag) {
            10 -> {
                textView.text = "My name is Toshi. I'm a doggy with style!"
                imageView.setImageDrawable(resources.getDrawable(R.drawable.toshi, context?.theme))
            }
            20 -> {
                textView.text = "My name is Snowflake. I am a tiny dog, and live in a tiny dog house."
                imageView.setImageDrawable(resources.getDrawable(R.drawable.snowflake, context?.theme))

            }
            30 -> {
                textView.text = "My name is Scooby Doo. I solve crime with my best friends."
                imageView.setImageDrawable(resources.getDrawable(R.drawable.scooby, context?.theme))
            }
        }

    }

}


