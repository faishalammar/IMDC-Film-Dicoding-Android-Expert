package dicoding.mobileprogramming.faishalammar.imdc

import android.app.Application
import dicoding.mobileprogramming.faishalammar.core.di.CoreComponent
import dicoding.mobileprogramming.faishalammar.core.di.DaggerCoreComponent
import dicoding.mobileprogramming.faishalammar.imdc.di.AppComponent
import dicoding.mobileprogramming.faishalammar.imdc.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }


}