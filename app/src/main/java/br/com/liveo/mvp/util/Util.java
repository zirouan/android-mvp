package br.com.liveo.mvp.util;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.liveo.mvp.base.BaseModel;
import retrofit2.HttpException;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class Util {

    public static String getMessageErro(HttpException httpException) {
        JSONObject error;
        try {
            error = new JSONObject(Util.convertStreamToString(
                    httpException.response().errorBody().byteStream()));
            BaseModel baseError = new Gson().fromJson(error.toString(), BaseModel.class);
            return baseError.errorMessage;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
