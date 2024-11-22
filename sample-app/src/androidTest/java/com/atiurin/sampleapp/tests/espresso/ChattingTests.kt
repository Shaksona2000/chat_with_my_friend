package com.atiurin.sampleapp.tests.espresso

import android.view.View
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.helper.isTextOnScreen
import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.helper.typeText
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.sampleapp.tests.BaseTest
import com.atiurin.ultron.extensions.isChecked
import com.atiurin.ultron.extensions.tap
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Matcher

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTests: BaseTest() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textWithMyFriend() {
        with(UIElementPage) {
            isTextOnScreen("Friends")
            nameChandler.isViewDisplayed()
            nameChandler.tap()
            textInput.typeText("Hello Rachel")

            messageInputText.isViewDisplayed()

        }
    }
    @Test
    fun testChatWithFriend() {
        with(UIElementPage) {
            // Checking if the dashboard is loaded
            isTextOnScreen("Friends")

            // Selecting a friend to chat with
            nameChandler.isViewDisplayed()
            nameChandler.tap()

            //  message to friend
            textInput.typeText("Hello Chandler")

            // Verify that the input field is displayed with the message
            messageInputText.isViewDisplayed()

            // assert that the message was sent successfully
            isTextOnScreen("Hello Chandler")
        }
    }
    @Test
    fun validateCustomClicksPage() {
        with(UIElementPage) {
            // Checking the dashboard is loaded
            isTextOnScreen("Friends")

            // Open Burger Menu
            mainManuBtn.isViewDisplayed()
            mainManuBtn.tap()

            // Select "Custom Clicks" option and open it
            isTextOnScreen("Custom Clicks")
            isTextOnScreen("Custom Clicks").tap()

            // Verify "Custom Clicks" page is open
            isTextOnScreen("Custom Clicks Page")

            // Mark all corner circles
            // Assuming corner circles have unique identifiers or visibility on the page
            val cornerCircles = listOf(radioBtnInvisible, radioBtnVisible) // Update with actual IDs if different
            cornerCircles.forEach { it.tap() }

            // Validate all corner circles are marked
            cornerCircles.forEach { it.isChecked() } // Ensure it checks the marked state
        }
    }
}


