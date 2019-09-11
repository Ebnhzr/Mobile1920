package com.github.ebnhzr.loremgen

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewParent
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ArrayAdapter.createFromResource
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.ebnhzr.loremgen.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val loremIpsum: Mydata = Mydata(
        "Lorem Ipsum",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus est magna, porttitor dictum velit nec, lobortis molestie risus. Etiam in viverra dui, quis viverra mi. Pellentesque et cursus eros. Ut ut felis tortor. Nunc a feugiat lectus, et mollis nunc. Sed eget elit justo. Vestibulum tincidunt, orci eget cursus scelerisque, tortor dui feugiat urna, ut posuere ex tortor id neque. Nullam tincidunt nibh eget lorem maximus, vel aliquam diam placerat. Vestibulum euismod risus ut nisl molestie, sed placerat enim dictum.\n" +
                "Curabitur sit amet euismod libero. Donec eros ex, mollis in faucibus ut, mollis eget nisl. Donec tincidunt auctor arcu nec sodales. In tincidunt urna vitae elit posuere vestibulum. Proin placerat ut dui eu gravida. Praesent eget aliquam neque. Pellentesque placerat odio sed enim tempor tempor. Sed luctus arcu id massa maximus facilisis. Nulla semper quam lacus, a posuere augue commodo quis. Ut vestibulum eu dolor eu porta. Phasellus mattis eros ac ultricies tincidunt. Vivamus et nisl porttitor urna venenatis vehicula. Nullam eget arcu condimentum, sollicitudin mi porta, gravida ligula. Nunc nisl felis, maximus sit amet laoreet et, mattis sed risus. Duis sollicitudin nunc diam, vel ullamcorper nunc interdum eget. Ut scelerisque rhoncus lorem iaculis tristique."
    )
    private val cheeseIpsum: Mydata = Mydata(
        "Cheese Ipsum",
        "Squirty cheese cheese and wine the big cheese. Cottage cheese fromage frais cheesy grin ricotta cottage cheese hard cheese halloumi pecorino. Cheese strings macaroni cheese cut the cheese cauliflower cheese boursin red leicester fromage frais who moved my cheese. Fromage.\n" +
                "Cheese triangles halloumi halloumi. When the cheese comes out everybody's happy ricotta cheesy grin cheesecake parmesan the big cheese who moved my cheese dolcelatte. Emmental smelly cheese who moved my cheese swiss when the cheese comes out everybody's happy caerphilly fondue cheddar. Danish fontina fromage frais mozzarella."
    )
    private val tunaIpsum: Mydata = Mydata(
        "Tuna Ipsum",
        "Emperor bream squaretail lemon sole titan triggerfish smelt-whiting salmon shark squarehead catfish. Tripod fish, striped bass squarehead catfish porbeagle shark threespine stickleback, smalltooth sawfish. Sea snail hoki dab sandburrower pearl perch, wobbegong longnose dace herring golden trout pygmy sunfish rudd eeltail catfish. Streamer fish jewelfish sea catfish tarwhine yellowfin croaker, sleeper shark California smoothtongue.\n" +
                "Snubnose parasitic eel delta smelt; Australian herring perch weasel shark, temperate ocean-bass molly smelt. Sailbearer brotula river stingray, menhaden threadfin Bengal danio sandbar shark Peter's elephantnose fish."
    )
    private val kiwiIpsum: Mydata = Mydata(
        "Kiwi Ipsum",
        "Kia ora.. Spit the dummy, this crook cuzzie is as pearler as a heaps good housie. Mean while, in that one episode of Tux Wonder Dogs, you know the one bro, The Topp Twins and Jonah Lomu were up to no good with a bunch of bung chilly bins. The fully sick force of his playing rugby was on par with John Key’s beaut whitebait fritter. Put the jug on will you bro, all these shithouse wifebeater singlets can wait till later. The first prize for cooking up a feed goes to… Uncle Bully and his buzzy rugby ball, what a hottie. Bro, Silver Ferns are really outrageously awesome good with hard yakka pikelets, aye. You have no idea how dodgy our snarky foreshore and seabed issues were aye. Every time I see those beautiful kiwiburgers it’s like the fish n’ chip shop all over again aye, I was just at home having some dots….. Anyway, Hercules Morse, as big as a horse is just Rhys Darby in disguise, to find the true meaning of life, one must start whale watching with the Jafa, mate. After the gumboot is packed a sad, you add all the pretty suss Hei-tikis to the mate you’ve got yourself a meal.\n" +
                "I’m not here to frack spiders, au, you don’t know his story, bro. Technology has allowed sweet as kai moanas to participate in the global conversation of mint boxes of fluffies. The next Generation of sweet eggs have already cooked over at the tinny house. What’s the hurry Bazza? There’s plenty of cookie times in the wop wops. Mt Cook holds the most rip-off community in the country.. Manus Morissette was rooting when the tip-top burning my Vogel’s event occured. Pavalova is definitely not Australian, this stoked seabed is as primo as a epic chick."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

            binding.loremIpsum = loremIpsum
            binding.cheeseIpsum = cheeseIpsum
            binding.tunaIpsum = tunaIpsum
            binding.kiwiIpsum = kiwiIpsum


        val adapter = ArrayAdapter.createFromResource(this, R.array.lorem_list, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremSpinner.adapter = adapter

        binding.loremSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val currentType: String = binding.loremSpinner.getItemAtPosition(position).toString()
                when (currentType) {
                    "Lorem Ipsum" -> {
                        binding.titleText.text = loremIpsum.type
                        binding.loremText.text = loremIpsum.content
                    }
                    "Cheese Ipsum" -> {
                        binding.titleText.text = cheeseIpsum.type
                        binding.loremText.text = cheeseIpsum.content
                    }
                    "Tuna Ipsum" -> {
                        binding.titleText.text = tunaIpsum.type
                        binding.loremText.text = tunaIpsum.content
                    }
                    "Kiwi Ipsum" -> {
                        binding.titleText.text = kiwiIpsum.type
                        binding.loremText.text = kiwiIpsum.content
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("LoremGen", "well, if nothing selected")
            }
        }

        binding.creatorButton.setOnClickListener {
            pickCreatorName(binding.creatorButton)
            it.hideKeyboard()
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }
    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    private  fun pickCreatorName(view: View) {
        binding.apply {
            creatorText.text = creatorFill.text.toString()
            creatorFill.visibility = View.GONE
            view.visibility = View.GONE
            loremSpinner.visibility = View.GONE
            creatorText.visibility = View.VISIBLE
        }

    }

    private fun changeCreatorName(view: View) {
        binding.apply {
            view.visibility = View.GONE
            creatorFill.visibility = View.VISIBLE
            creatorButton.visibility = View.VISIBLE
            loremSpinner.visibility = View.VISIBLE
            creatorFill.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.creatorFill, 0)
    }
}

