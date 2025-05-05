package com.example.androidcomposemarvel.ui

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import com.example.androidcomposemarvel.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test fun appNameIsVisible_onLaunch() {
        composeRule.onNodeWithText("AndroidComposeMarvel")
            .assertIsDisplayed()
    }
}
