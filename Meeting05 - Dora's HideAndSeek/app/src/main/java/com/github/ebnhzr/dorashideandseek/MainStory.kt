package com.github.ebnhzr.dorashideandseek

import android.app.Application

class MainStory: Application() {

    data class Scene(
        val title: String,
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val Main_Menu = "Main Menu"
        val Retry = "Retry"
        val Continue = "Continue"

        // Scenes
        val scenes: List<Scene> = listOf (
            // 0 INTRODUCTION
            Scene (
                "Introduction",
                "In this game you became Dora! Dora is bored and she is trying to play a hide and seek",
                actions = listOf (
                    "Proceed to story",
                    "Proceed to story",
                    "Proceed to story",
                    "Proceed to story"
                )
            ),

            // 1
            Scene (
                "Boots Bored Too",
                "Boots saw Dora trying to play hide and seek. Boots believe hide and seek can't be done with just a person. He went to Dora and say, 'Boots hungry, give food!'",
                actions = listOf (
                    "Give boots a fish",
                    "Kick Boots",
                    "Ignore Boots",
                    "Leave.."
                )
            ),

            // 2
            Scene (
                "BOOTS IS PLEASED"
                "Boots now follow you wherever you go! What you want to do now?",
                actions = listOf (
                    "Play hide and seek with boots",
                    "Leave",
                    "",
                    ""
                )
            ),

            // 3
            Scene (
                "WHY YOU HIT BOOTS?",
                "I cant believe you've done dis (said boots)"  ,
                actions = listOf (
                    "Im sorry!",
                    "Leave him",
                    "",
                    ""
                )
            ),

            // 4
            Scene (
                "BOOTS IS NOW SAD",
                "Boots ran away",
                actions = listOf (
                    "Look for Boots",
                    "Ignore Boots",
                    "",
                    ""
                )
            ),

            // 5
            Scene (
                "BOOTS FORGIVE YOU",
                "You say sorry to Boots and ask him to play with you",
                actions = listOf (
                    "Give Boots a fish",
                    "Kick Boots again!",
                    "",
                    ""
                )
            ),

            // 6 DORA PLAY H&S WITH BOOTS
            Scene (
                "Dora and Boots play hide and seek",
                "After Boots hide in the jungle, Dora tried to find him. On the way finding Boots, Dora something rattling behind her. Something came out behind the tree and it was SWIPER! He was spying on them."+
                        "Swiper want to join them",
                actions = listOf (
                    "REJECT HIM AND FIND BOOTS by saying SWIPER NO SWIPING\",
                    "LET HIM JOIN TO HELP HER FIND BOOTS",
                    "RUN",
                    ""
                )
            ),

            // 7 BAD ENDING 1
            Scene (
                "You Ran",
                "You left Boots alone in the jungle",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),
            // 8 SWIPER LEFT

            Scene (
                "AWWW MANNN",
                "SWIPER LEFT",
                actions = listOf(
                    "Continue Playing",
                    "Im tired",
                    "",
                    ""
                )
            ),
            // 9 NORMAL ENDING
            Scene (
                "YAY WE DID IT",
                "DORA FINALLY FINDS BOOTS. They went back home",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),
            // 10 BAD ENDING 2
            Scene (
                "BOOTS IS NOW DEAD",
                "YOU DONT DESERVE BOOTS",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 11 BEST ENDING
            Scene (
                "BEST ENDING",
                "Dora decided to let Swiper join. They both decided to find Boots in the jungle"+"\n" +
                        "THEY FOUND BOOTS TOGETHER EASILY, THE END",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            )



        )

        // ending flags
        var badEnding1 = false
        var badEnding2 = false
        var normalEnding1 = false
        var bestEnding = false

        // utility
        lateinit var currentDisplayedEnding: Scene
    }
}