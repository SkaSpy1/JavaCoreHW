package lesson7;

import lesson7.entity.Weather;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherModel
{
    void getWeather(String selectedCity, Period period) throws IOException, SQLException;

    List<Weather> getSavedToDBWeather();
}