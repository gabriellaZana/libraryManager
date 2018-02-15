package com.threelittlepigs.codecool.libraryManager.Utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import spark.Request;

import java.lang.reflect.Type;
import java.util.Map;

public class JSONUtils {

    public static Map<String, String> parseJson(Request request) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> out = gson.fromJson(request.body(), type);
        return out;
    }
}
