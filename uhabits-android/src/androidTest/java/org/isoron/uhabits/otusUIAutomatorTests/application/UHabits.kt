package org.isoron.uhabits.otusUIAutomatorTests.application

import androidx.test.uiautomator.UiObject2
import org.isoron.uhabits.otusUIAutomatorTests.util.*
import org.junit.Assert

class UHabits : AbstractApplication("org.isoron.uhabits") {

    fun clickAddHabitButton() {
        byDescContains("Add habit").waitFindObject().click()
    }

    fun clickOptionsButton() {
        byDescContains("More options").waitFindObject().click()
    }

    fun clickOnOptionsItem(item: String) {
        byStringText(item).waitFindObject().click()
    }

    fun clickYesOrNoButton() {
        byStringText("Yes or No").waitFindObject().click()
    }

    fun typeHabitName(text: String) {
        byStringRes("nameInput").waitFindObject().text = text
    }

    fun clickSaveButton() {
        byStringRes("buttonSave").waitFindObject().click()
    }

    fun getDarkThemeCheckBox() : UiObject2 {
        return byStringRes("checkbox").waitFindObject()
    }

    fun getHabit(text: String): UiObject2 {
        return byStringText(text).waitFindObject()
    }

    fun getAboutScreenTitle(): UiObject2 {
        return byStringText("About").waitFindObject()
    }

    fun getHabitCreatedSnackBar(): UiObject2 {
        return byStringText("Habit created").waitFindObject()
    }

    fun checkWarningMessage(text: String) {
        Assert.assertEquals(
            text,
            byStringText("Необходимо ввести логин и пароль").getMessageValue().text
        )
    }

    fun checkErrorMessage(text: String) {
        Assert.assertEquals(
            text,
            byStringText("Логин или пароль введен неверно").getMessageValue().text
        )
    }

    fun checkSuccessMessage(text: String) {
        Assert.assertEquals(
            text,
            byStringText("Успешный вход в приложение").getMessageValue().text
        )
    }

    fun clickOnOkButton() {
        byStringText("ОК").waitFindObject().click()
    }
}