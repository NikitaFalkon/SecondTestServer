package com.service;

import com.entity.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ApacheService {
    void createNewDoc(File file, List<Document> documents) throws IOException;
}
