package com.service;

import com.entity.Document;
import com.interfaces.DocumentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    public String findSum(List<Document> documentList){
        List<Integer> ints1 = new ArrayList<>();
        List<Integer> ints2 = new ArrayList<>();
        int i = 0;
        int j = 0;

        documentList.forEach(document -> {
            Double d =  Double.parseDouble(document.getSum());
            String[] a = String.valueOf(d).split("[.]");
            ints1.add(Integer.parseInt(a[0]));
            ints2.add(Integer.parseInt(a[1]));
        });

        for (int o=0; o<ints1.size(); o++) {
            i+=ints1.get(o);
            j+=ints2.get(o);
        }

        i/=ints1.size();
        j/=ints2.size();
        String sum = i+"."+j;

        return sum;
    }
}
