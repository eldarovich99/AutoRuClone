package ru.uzbekovve.autopl

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.uzbekovve.autopl.di.guideModule

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApp)
            modules(guideModule) // TODO remove from app, so it will be possible to attach guideModule to Guide screen
        }
    }
}