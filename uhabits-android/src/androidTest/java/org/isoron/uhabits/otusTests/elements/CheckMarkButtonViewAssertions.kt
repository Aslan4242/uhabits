package org.isoron.uhabits.otusTests.elements

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.common.assertions.BaseAssertions
import junit.framework.Assert
import org.hamcrest.Matchers
import org.isoron.uhabits.activities.habits.list.views.CheckmarkButtonView

interface CheckMarkButtonViewAssertions : BaseAssertions {

    /**
     * Check if CheckMarkButtonView has notes
     *
     * @see CheckMarkButtonView
     */
    fun hasNotes() {

        view.perform(object : ViewAction {
            override fun getDescription() = "Get CheckMarkButton's color"

            override fun getConstraints() =
                Matchers.allOf(ViewMatchers.isAssignableFrom(CheckmarkButtonView::class.java), ViewMatchers.isDisplayed())

            override fun perform(uiController: UiController?, view: View?) {
                if (view is CheckmarkButtonView) {
                    Assert.assertTrue(
                        "CheckMarkButton doesn't have notes",
                        view.hasNotes
                    )
                }
            }
        })

    }

}
