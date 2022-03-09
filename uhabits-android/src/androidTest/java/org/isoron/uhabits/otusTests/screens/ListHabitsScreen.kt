package org.isoron.uhabits.otusTests.screens

import androidx.appcompat.widget.ActionMenuView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import org.isoron.uhabits.R
import org.isoron.uhabits.activities.habits.list.views.CheckmarkButtonView
import org.isoron.uhabits.activities.habits.list.views.CheckmarkPanelView
import org.isoron.uhabits.otusTests.base.BaseScreen
import org.isoron.uhabits.otusTests.elements.KCheckMarkButtonView

object ListHabitsScreen : BaseScreen<ListHabitsScreen>() {

    val createHabit = KButton { withId(R.id.actionCreateHabit) }

    val actionMenu = KButton {
        withIndex(2){
            withParent {
                isInstanceOf(ActionMenuView::class.java)
            }
        }
    }

    /**
     * Выбирает привычку с указанным названием
     *
     * @param [name] Название привычки
     * @return [KTextView] Привычка
     */
    fun getHabit(name: String): KTextView {
        return KTextView { withText(name) }
    }

    /**
     * Возвращает отметку выполнения привычки с указанным индексом
     *
     * @param [name] Название привычки
     * @param [index] Индекс отметки
     * @return [KTextView] Отметка
     */
    fun getMarkButton(name: String, index: Int): KCheckMarkButtonView {
        return KCheckMarkButtonView {
            withIndex(index) {
                isInstanceOf(CheckmarkButtonView::class.java)
                withParent {
                    isInstanceOf(CheckmarkPanelView::class.java)
                    withSibling { withText(name) }
                }
            }
        }
    }
}
