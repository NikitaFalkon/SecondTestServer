package com.service;

import com.entity.Document;
import com.entity.Organization;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public interface JsonService {
    JSONObject toJsonList(List<Organization> organizations);

    JSONObject newJsonObject(Organization organization) throws JSONException;

    JSONObject documentsToJson(List<Document> documentList, String sum) throws JSONException;
}
