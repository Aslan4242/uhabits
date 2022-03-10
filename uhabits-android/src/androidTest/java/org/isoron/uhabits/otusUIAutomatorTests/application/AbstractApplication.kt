package org.isoron.uhabits.otusUIAutomatorTests.application

import android.content.Intent
import org.isoron.uhabits.otusUIAutomatorTests.util.byPackage
import org.isoron.uhabits.otusUIAutomatorTests.util.context
import org.isoron.uhabits.otusUIAutomatorTests.util.waitHasObject


abstract class AbstractApplication(val packageName: String) {
    open fun open() {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
        byPackage(packageName).waitHasObject()

    }
}