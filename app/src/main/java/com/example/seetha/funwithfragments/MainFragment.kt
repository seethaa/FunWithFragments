package com.example.seetha.funwithfragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment(), View.OnClickListener {
    private lateinit var callback: OnButtonClickedListener

    override fun onClick(v: View) {
        callback.onButtonClicked(v)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val result = inflater.inflate(R.layout.fragment_main, container, false)
        return result
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_main_button.setOnClickListener(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnButtonClickedListener) {
            //Parent activity will automatically subscribe to callback

            callback = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnButtonClickedListener.")
        }

    }

    interface OnButtonClickedListener {
        fun onButtonClicked(view: View)
    }


}


