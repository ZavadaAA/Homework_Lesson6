package Lesson_6.HW_Lesson_6;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Forecast {

        public static void main(String[] args) throws IOException {
            OkHttpClient okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            MediaType JSON = MediaType.parse("application/json");
            String authBodyString = "{"+
                    "\"username\": \"ZavadaAA\", "+
                    "\"password\": \"Zavada701\""+ "}";
            System.out.println(authBodyString);

            RequestBody requestBody = RequestBody.create(authBodyString, JSON);
            Request request = new Request.Builder()
                    .url("https://developer.accuweather.com/user/login")
                    .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=bY9sFyXGO5fB2bwx9ueDnA6mmqcow3Hn&language=ru-ru")
                    .post(requestBody)
                    .build();

            Response response = okHttpClient.newCall(request).execute();

            String responseBody = response.body().string();
            System.out.println(responseBody);

        }
    }