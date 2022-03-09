package org.isoron.uhabits.otusTests.screens


import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.text.KTextView
import com.google.android.material.textview.MaterialTextView
import org.isoron.uhabits.R
import org.isoron.uhabits.otusTests.base.BaseScreen

object AboutScreen : BaseScreen<AboutScreen>() {

    val title = KTextView {
        isInstanceOf(AppCompatTextView::class.java)
        withParent { withId(R.id.toolbar) }
    }

    val logo = KImageView { isInstanceOf(AppCompatImageView::class.java) }

    val appName = KTextView {
        isInstanceOf(MaterialTextView::class.java)
        withSibling { withId(R.id.tvVersion) }
    }
}
