package org.isoron.uhabits.otusTests.base

import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.testcases.core.sections.InitSection
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import org.isoron.uhabits.activities.habits.list.ListHabitsActivity

open class BaseTestCase : TestCase() {

    /**
     * Действия, выполняемые до запуска теста
     *
     * @param [userDataType] Пользователь из списка [UserDataType], от лица которого будет выполняться сценарий
     * @param [before] Действия, которые следует выполнить до теста
     * @param [after] Действия, которые следует выполнить после теста
     */
    protected fun launch(
        before: BaseTestContext.() -> Unit = {},
        after: BaseTestContext.() -> Unit = {}
    ): InitSection<Unit, Unit> {
        ActivityTestRule(ListHabitsActivity::class.java, false, false)
            .launchActivity(null)
        return before(actions = before).after(after)
    }
}
