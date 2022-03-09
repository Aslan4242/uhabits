package org.isoron.uhabits.otusTests.screens


import androidx.appcompat.widget.AppCompatTextView
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import org.isoron.uhabits.R
import org.isoron.uhabits.otusTests.base.BaseScreen

object CreateHabitScreen : BaseScreen<CreateHabitScreen>() {

    val title = KTextView {
        isInstanceOf(AppCompatTextView::class.java)
        withParent {withId(R.id.toolbar)}
    }

    val saveButton = KButton { withId(R.id.buttonSave) }
    val nameField = KEditText { withId(R.id.nameInput) }

}
