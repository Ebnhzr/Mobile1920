package com.github.ebnhzr.dorashideandseek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.ebnhzr.dorashideandseek.databinding.FragmentEndingDisplayBinding


class EndingDisplay : Fragment() {

    val currentEnding: MainStory.Scene = MainStory.currentDisplayedEnding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingDisplayBinding>(inflater,
            R.layout.fragment_ending_display, container, false)

        binding.endingDisplay = this

        return binding.root
    }
    override fun onStart(){
        super.onStart()
        Timber.i("--onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("--onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("--onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("--onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("--onDestroy")
    }

}