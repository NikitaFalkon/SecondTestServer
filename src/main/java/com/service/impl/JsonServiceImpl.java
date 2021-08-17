package com.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Result;
import com.service.DocumentService;
import com.service.JsonService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonServiceImpl implements JsonService {
    @Autowired
    DocumentService documentService;
/*    @Override
    public JSONObject toJsonList(List<Organization> organizations) {
        JSONObject resultJson = new JSONObject();

        organizations.forEach(organization -> {

                    try {
                        JSONObject object = newJsonObject(organization);
                        resultJson.put(organization.getCname(), object);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
        );

        return resultJson;
    }*/

    @Override
    @Cacheable(cacheNames = "result")
    public JSONObject newJsonObject(Result result) throws JSONException {
        /*GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String all = "";

        return gson.toJson(result);*/
        JSONObject obj = new JSONObject();
        String s = "payer = " + result.getPay() + " recipient = " + result.getRec();
        obj.put(result.getName(), s);

        return obj;
    }

   /* @Override
    public JSONObject documentsToJson() throws JSONException {
        /*JSONObject obj = new JSONObject();
        for (Result result : results) {
            String s = "pay = " + result.getPay() + " rec = " + result.getRec();
            obj.put(result.getName(), s);
        }

        return obj;*/
    //}
}
