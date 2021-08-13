package com.service.impl;

import com.entity.Document;
import com.entity.Organization;
import com.repository.DocumentGrudRepository;
import com.repository.DocumentRepository;
import com.service.DocumentService;
import com.service.JsonService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

/*    @Override
    public JSONObject newJsonObject(Organization organization) throws JSONException {
        JSONObject obj = new JSONObject();
        int recdocuments = documentService.;
        int paydocuments = documentGrudRepository.findCountPay(organization.getCname());
        obj.put("pay", paydocuments);
        obj.put("rec", recdocuments);

        return obj;
    }*/

    @Override
    public JSONObject documentsToJson() throws JSONException {
        JSONObject obj = new JSONObject();
        List<Document> documentList = documentService.findAll();
        obj.put("documents", documentList.size());
        obj.put("sum", documentService.getAverageSum());

        return obj;
    }
}
