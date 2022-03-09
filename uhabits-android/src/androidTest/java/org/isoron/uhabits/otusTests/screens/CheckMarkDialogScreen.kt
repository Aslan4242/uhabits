package org.isoron.uhabits.otusTests.screens


import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import org.isoron.uhabits.R
import org.isoron.uhabits.otusTests.base.BaseScreen

object CheckMarkDialogScreen : BaseScreen<CheckMarkDialogScreen>() {

    val title = KTextView {withId(R.id.alertTitle)}
    val yesBtn = KButton { withId(R.id.yesBtn) }
    val noBtn = KButton { withId(R.id.noBtn) }
    val notesField = KEditText { withId(R.id.etNotes) }
    val cancelButton = KButton { withText("Cancel") }
    val saveButton = KButton { withText("Save") }

}
