package org.isoron.uhabits.otusUIAutomatorTests.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.isoron.uhabits.otusUIAutomatorTests.application.UHabits
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HabitsUIAutomatorTest : AbstractApplicationTest<UHabits>(UHabits()) {

    @Test
    fun createHabitTest() {
        app.run {
            val habitName = "Моя привычка"
            // Открываем приложение
            open()

            // Нажимаем на кнопку добавления привычки
            clickAddHabitButton()

            // Выбираем тип привычки 'Yes or No'
            clickYesOrNoButton()

            //На экране 'Create Habit' вводим имя привычки '$habitsName' и сохраняем
            typeHabitName(habitName)
            clickSaveButton()

            // Проверяем,что привычка появилась
            getHabitCreatedSnackBar().isEnabled
            getHabit(habitName).run {
                isClickable
                isEnabled
            }
        }
    }

    @Test
    fun openAboutScreenTest() {
        app.run {
            // Открываем приложение
            open()

            // Нажимаем на меню
            clickOptionsButton()

            // Нажимаем на 'About'
            clickOnOptionsItem("About")

            // Проверяем открытие экрана 'About'
            getAboutScreenTitle().isEnabled
        }
    }

    @Test
    fun enableDarkTheme() {
        app.run {
            // Открываем приложение
            open()

            // Нажимаем на меню
            clickOptionsButton()

            // Нажимаем на 'Dark theme'
            clickOnOptionsItem("Dark theme")

            // Нажимаем на меню
            clickOptionsButton()

            // Проверяем что появилась галочка у 'Dark theme'
            Assert.assertTrue(getDarkThemeCheckBox().isChecked)

            // Отключаем 'Dark theme'
            clickOnOptionsItem("Dark theme")
        }
    }
}