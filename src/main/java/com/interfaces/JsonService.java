package com.interfaces;

import com.entity.Document;
import com.entity.Organization;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public interface JsonService {
    public JSONObject toJsonList(List<Organization> organizations);
    public JSONObject newJsonObject(Organization organization) throws JSONException;
    public JSONObject documentsToJson(List<Document> documentList, String sum) throws JSONException;
}
