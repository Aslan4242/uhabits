package org.isoron.uhabits.otusTests.base

import com.agoda.kakao.screen.Screen

abstract class BaseScreen<out T : BaseScreen<T>> : Screen<T>() {
}