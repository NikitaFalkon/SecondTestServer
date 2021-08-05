package com.service;

import com.entity.Document;
import com.entity.Organization;
import com.interfaces.JsonService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonServiceImpl implements JsonService {
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
    }

    public JSONObject newJsonObject(Organization organization) throws JSONException {
        JSONObject obj = new JSONObject();
        int recdocuments = organization.getRecipientDocuments().size();
        int paydocuments = organization.getPayerDocuments().size();
        obj.put("pay", paydocuments);
        obj.put("rec", recdocuments);

        return obj;
    }

    public JSONObject documentsToJson(List<Document> documentList, String sum) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("documents", documentList.size());
        obj.put("sum", sum);

        return obj;
    }
}
