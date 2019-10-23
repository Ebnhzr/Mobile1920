package com.github.ebnhzr.meeting07_dorahideandseek2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.github.ebnhzr.meeting07_dorahideandseek2.databinding.FragmentMainMenuBinding
import timber.log.Timber

class MainMenu : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(inflater,
            R.layout.fragment_main_menu, container, false)

        binding.startButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainMenu_to_gameFragment)
        }

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