package com.github.ebnhzr.meeting07_dorahideandseek2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.github.ebnhzr.meeting07_dorahideandseek2.databinding.FragmentEndingsBinding
import timber.log.Timber

class EndingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingsBinding>(inflater,
            R.layout.fragment_endings, container, false)

        // Ending Buttons Listeners...
        binding.badEndingOneButton.setOnClickListener {
            MainStory.currentDisplayedEnding = MainStory.scenes[7]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingTwoButton.setOnClickListener {
            MainStory.currentDisplayedEnding = MainStory.scenes[10]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }

        binding.normalEndingOneButton.setOnClickListener {
            MainStory.currentDisplayedEnding = MainStory.scenes[9]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.bestEndingButton.setOnClickListener {
            MainStory.currentDisplayedEnding = MainStory.scenes[11]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }

        // Enabling/disabling buttons
        if (MainStory.badEnding1) binding.badEndingOneButton.isEnabled = true
        if (MainStory.badEnding2) binding.badEndingTwoButton.isEnabled = true
        if (MainStory.normalEnding1) binding.normalEndingOneButton.isEnabled = true
        if (MainStory.bestEnding) binding.bestEndingButton.isEnabled = true

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