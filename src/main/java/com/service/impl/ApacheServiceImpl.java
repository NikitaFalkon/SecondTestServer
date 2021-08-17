package com.service.impl;

import com.entity.Document;
import com.service.ApacheService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ApacheServiceImpl implements ApacheService {
    @Override
    @Cacheable(cacheNames = "documents")
    public void createNewDoc(File file, List<Document> documents) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Documents");
        Row row1 = sheet.createRow(0);
        Cell number1 = row1.createCell(0);
        number1.setCellValue("Номер документа");
        Cell date1 = row1.createCell(1);
        date1.setCellValue("Дата документа");
        Cell sum1 = row1.createCell(2);
        sum1.setCellValue("Сумма документа");
        Cell namepayer1 = row1.createCell(3);
        namepayer1.setCellValue("Наименование плательщика");
        Cell bicbankp1 = row1.createCell(4);
        bicbankp1.setCellValue("БИК банка плательщика");
        Cell namecell1 = row1.createCell(5);
        namecell1.setCellValue("Наименование получателя");
        Cell bicbankc1 = row1.createCell(6);
        bicbankc1.setCellValue("БИК банка получателя");

        for (int x = 0; x < documents.size(); x++) {
            Row row = sheet.createRow(x+1);
            Cell number = row.createCell(0);
            number.setCellValue(documents.get(x).getNumber());
            Cell date = row.createCell(1);
            date.setCellValue(documents.get(x).getDate());
            Cell sum = row.createCell(2);
            sum.setCellValue((RichTextString) documents.get(x).getAmount());
            Cell namepayer = row.createCell(3);
            namepayer.setCellValue(documents.get(x).getPayerOrganization().getCname());
            Cell bicbankp = row.createCell(4);
            bicbankp.setCellValue(documents.get(x).getPayerBank().getBic());
            Cell namecell = row.createCell(5);
            namecell.setCellValue(documents.get(x).getRecipientOrganization().getCname());
            Cell bicbankc = row.createCell(6);
            bicbankc.setCellValue(documents.get(x).getRecipientBank().getBic());
        }

        book.write(new FileOutputStream(file));
        book.close();
    }
}
