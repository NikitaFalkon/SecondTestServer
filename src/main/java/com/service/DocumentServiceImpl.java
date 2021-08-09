package com.service;

import com.entity.Document;
import com.interfaces.DocumentService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    public String findSum(List<Document> documentList){
        Double sum = 0.0;

        for (int o=0; o<documentList.size(); o++) {
            sum+=documentList.get(o).getSum().doubleValue();
        }

        sum/=documentList.size();
        DecimalFormat f = new DecimalFormat("##.00");

        return f.format(sum);
    }
}
