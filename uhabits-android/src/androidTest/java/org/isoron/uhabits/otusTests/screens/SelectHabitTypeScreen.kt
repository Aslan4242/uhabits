package org.isoron.uhabits.otusTests.screens


import com.agoda.kakao.text.KTextView
import org.isoron.uhabits.R
import org.isoron.uhabits.otusTests.base.BaseScreen

object SelectHabitTypeScreen : BaseScreen<SelectHabitTypeScreen>() {

    val yesOrNo = KTextView { withId(R.id.buttonYesNo) }
    val measurable = KTextView { withId(R.id.buttonMeasurable) }

}
