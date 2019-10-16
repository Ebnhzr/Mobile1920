package com.github.ebnhzr.dorashideandseek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.ebnhzr.dorashideandseek.databinding.FragmentHowToPlayBinding

class HowToPlay : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHowToPlayBinding>(inflater,
            R.layout.fragment_how_to_play, container, false)

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