package lesson6;

import okhttp3.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Weather {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String LOCATIONS = "locations";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String API_KEY = "tQRQnpPZkJRAzipG5AW3VG1cu2TYBXZs";
    private static final String CITY = "Caнкт-Петербург";
    private static final String FILE = "forecast.json";
    public static void main(String args[]) throws IOException {
        System.out.printf("Нажмите Y , чтобы узнать погоду в г. %s?\n", CITY);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.printf("Принято: %s\n Погода в %s отправлена в файл %s \n", answer, CITY, FILE);
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", CITY)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response responseGetLocationKey = client.newCall(request).execute();

        if(responseGetLocationKey.code() != 200){
            System.out.println("Повторите запрос");
            return;
        }
        String responseBody = responseGetLocationKey.body().string();

        String locationKey = responseBody.split(":")[2];

        locationKey = locationKey.split(",")[0];
        locationKey = locationKey.replaceAll("[^\\p{L}\\p{Nd}]+", "");

        url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(locationKey)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response responseGetForecast = client.newCall(request).execute();

        if(responseGetForecast.code() != 200){
            System.out.println("Повторите запрос");
            return;
        }
        responseBody = responseGetForecast.body().string();
        try (PrintWriter out = new PrintWriter(FILE)) {
            out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}