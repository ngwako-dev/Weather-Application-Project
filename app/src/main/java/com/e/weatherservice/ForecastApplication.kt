package com.e.weatherservice

import android.app.Application
import androidx.preference.PreferenceManager
import com.e.weatherservice.model.db.ForecastDatabase
import com.e.weatherservice.model.network.*
import com.e.weatherservice.model.repository.ForecastRepository
import com.e.weatherservice.model.repository.ForecastRepositoryImpl
import com.e.weatherservice.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.Provider
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton {
            ForecastDatabase(instance())
        }
        bind() from singleton {
            instance<ForecastDatabase>().currentWeatherDao()
        }
        bind<ConnectivityInterceptor>() with singleton {
            ConnectivityInterceptorImpl(instance())
        }
        bind() from singleton {
            WeatherAPiService(instance())
        }
        bind<WeatherNetworkDataSource>() with singleton {
            WeatherNetworkDataSourceImpl(instance())
        }
        bind<ForecastRepository>() with singleton {
            ForecastRepositoryImpl(instance(), instance())
        }
        bind() from provider {
            CurrentWeatherViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

    }

}