package com.e.weatherservice

import android.app.Application
import android.system.Os.bind
import com.e.weatherservice.model.db.ForecastDatabase
import com.e.weatherservice.model.network.*
import com.e.weatherservice.model.repository.ForecastRepository
import com.e.weatherservice.model.repository.ForecastRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
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
    }


}