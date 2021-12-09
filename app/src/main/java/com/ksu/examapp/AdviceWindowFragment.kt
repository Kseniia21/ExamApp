package com.ksu.examapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_ADVICE_IMAGE="image"
class AdviceWindowFragment : Fragment() {

    lateinit var adviceImageView: ImageView
    lateinit var adviceButton: Button

    private val adviceImageList: List<Int> = listOf(
        R.drawable.advice1,
        R.drawable.advice2,
        R.drawable.advice3,
        R.drawable.advice4,
        R.drawable.advice5,
        R.drawable.advice6,
    )
    var lastAdviceImageRes=0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_advice_window, container, false)

        adviceImageView = view.findViewById(R.id.advice_image_view)
        adviceButton = view.findViewById(R.id.new_advice_button)

        if (savedInstanceState!=null)
            adviceImageView.setImageResource(savedInstanceState.getInt(LAST_ADVICE_IMAGE))

        adviceButton.setOnClickListener{
            lastAdviceImageRes=adviceImageList.random()
            adviceImageView.setImageResource(lastAdviceImageRes)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ADVICE_IMAGE,lastAdviceImageRes)
    }
}