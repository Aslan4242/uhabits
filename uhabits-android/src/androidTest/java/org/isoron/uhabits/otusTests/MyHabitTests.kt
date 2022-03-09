package org.isoron.uhabits.otusTests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.isoron.uhabits.otusTests.base.BaseTestCase
import org.isoron.uhabits.otusTests.screens.*
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MyHabitTests : BaseTestCase() {

    @Test
    fun createHabitTest() {
        launch().run {
            val habitsName = "Каждый день писать тесты"

            createHabit(habitsName)

            step("Проверяем отображение созданной привычки") {
                ListHabitsScreen {
                    getHabit(habitsName).isDisplayed()
                }
            }

            step("Нажимаем на созданную привычку") {
                ListHabitsScreen {
                    getHabit(habitsName).click()
                }
            }

            step("Проверяем название привычки") {
                CreateHabitScreen {
                    title {
                        hasText(habitsName)
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun checkMarkButtonTest() {
        launch().run {
            val habitsName = "Каждый день писать тесты 2"

            createHabit(habitsName)

            step("Нажимаем на первую отметку выполнения привычки '$habitsName'") {
                ListHabitsScreen {
                    getMarkButton(habitsName, 0).click()
                }
            }

            step("Редактируем отметку и сохраняем") {
                CheckMarkDialogScreen {
                    title.isDisplayed()
                    yesBtn.click()
                    notesField.replaceText("Done")
                    saveButton.click()
                }
            }

            step("Проверяем, что отметка выполнения привычки '$habitsName' изменилась") {
                ListHabitsScreen {
                    getMarkButton(habitsName, 0).run {
                        isDisplayed()
                        hasNotes()
                    }
                }
            }
        }
    }

    @Test
    fun openAboutScreenTest() {
        launch().run {
            val aboutScreen = "About"

            step("Нажимаем на меню") {
                ListHabitsScreen {
                    actionMenu.click()
                }
            }

            step("Нажимаем на '$aboutScreen'") {
                ActionMenuScreen {
                    about.click()
                }
            }

            step("Проверяем открытие экрана '$aboutScreen' и отображение логотипа и названия приложения") {
                AboutScreen {
                    title {
                        isDisplayed()
                        hasText(aboutScreen)
                    }
                    logo.isDisplayed()
                    appName {
                        isDisplayed()
                        hasText("Loop Habit Tracker")
                    }
                }
            }
        }
    }

    /**
     * Создает новую привычку
     *
     * @param [habitsName] Имя привычки
     */
    private fun TestContext<Unit>.createHabit(habitsName: String) {
        step("Нажимаем на кнопку добавления привычки") {
            ListHabitsScreen {
                createHabit.click()
            }
        }

        step("Выбираем тип привычки 'Yes or No'") {
            SelectHabitTypeScreen {
                yesOrNo.click()
            }
        }

        step("На экране 'Create Habit' вводим имя привычки '$habitsName' и сохраняем") {
            CreateHabitScreen {
                nameField.replaceText(habitsName)
                saveButton.click()
            }
        }
    }
}
