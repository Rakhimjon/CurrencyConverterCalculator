package mustafaozhan.github.com.mycurrencies.application

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric
import mustafaozhan.github.com.mycurrencies.BuildConfig
import mustafaozhan.github.com.mycurrencies.dagger.component.ApplicationComponent
import mustafaozhan.github.com.mycurrencies.dagger.component.DaggerApplicationComponent
import mustafaozhan.github.com.mycurrencies.dagger.module.ApplicationModule

/**
 * Created by Mustafa Ozhan on 7/10/18 at 9:43 PM on Arch Linux wit Love <3.
 */
class Application : MultiDexApplication() {
    //For supporting multidex before android 5
    companion object {
        lateinit var instance: Application

        fun get(context: Context): Application {
            return context.applicationContext as Application
        }
    }

    override fun onCreate() {
        super.onCreate()

        val core = CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()
        Fabric.with(this, Crashlytics.Builder().core(core).build())

        instance = this
    }

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder() // will be auto generated after build
                .applicationModule(ApplicationModule(this)).build()
    }

}