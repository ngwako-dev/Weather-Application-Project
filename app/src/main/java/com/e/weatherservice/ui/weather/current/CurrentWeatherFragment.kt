package com.e.weatherservice.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.e.weatherservice.R
import com.e.weatherservice.base.ScopedFragment
import com.e.weatherservice.model.network.*
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)

        bindViews()
    }

    private fun bindViews() = launch{
        val currentWeather = viewModel.weather.await()
        currentWeather.observe(this@CurrentWeatherFragment, Observer {
            if (it == null) return@Observer
            group_loading.visibility = View.GONE
            updateLocation("Johannesburg")
            updateDateToToday()
            updatePrecipitation(it.precipitationVolume)
            updateVisibility(it.visibilityDistance)
            updateWind(it.windDirection, it.windSpeed)

        })
    }

    private fun chooseLocalizedUnitAbbreviation(metric: String, imperial: String): String {
        return if (viewModel.isMetric) metric else imperial
    }

    private fun updateLocation(location: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = location

    }

    private fun updateDateToToday() {
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = "Today"
    }

    private fun updateTemperatures(temperature: Double, feelsLike: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("°C", "°F")
        textView_temperature.text = "$temperature$unitAbbreviation"
        textView_feels_like_temperature.text = "Feels like $feelsLike$unitAbbreviation"
    }

    private fun updatePrecipitation(precipitationVolume: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("mm", "in")
        textView_precipitation.text = "Preciptiation: $precipitationVolume $unitAbbreviation"
    }

    private fun updateWind(windDirection: String, windSpeed: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("kph", "mph")
        textView_wind.text = "Wind: $windDirection, $windSpeed $unitAbbreviation"
    }

    private fun updateVisibility(visibilityDistance: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("km", "mi.")
        textView_visibility.text = "Visibility: $visibilityDistance $unitAbbreviation"
    }

}