package org.isoron.uhabits.otusTests.screens

import com.agoda.kakao.text.KTextView
import org.isoron.uhabits.R
import org.isoron.uhabits.otusTests.base.BaseScreen

object ActionMenuScreen : BaseScreen<ActionMenuScreen>() {

    val about = KTextView {
        withId(R.id.title)
        withText("About")
    }
}
