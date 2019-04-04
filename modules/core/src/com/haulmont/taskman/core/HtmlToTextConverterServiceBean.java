package com.haulmont.taskman.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import java.io.Reader;
import java.io.StringReader;

@Service(HtmlToTextConverterService.NAME)
public class HtmlToTextConverterServiceBean implements HtmlToTextConverterService {

    private static final Logger log = LoggerFactory.getLogger(HtmlToTextConverterServiceBean.class);

    @Override
    public String convert(String htmlText) {
        EditorKit kit = new HTMLEditorKit();
        Document doc = kit.createDefaultDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        try {
            Reader reader = new StringReader(htmlText);
            kit.read(reader, doc, 0);
            return doc.getText(0, doc.getLength());
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        }
    }
}