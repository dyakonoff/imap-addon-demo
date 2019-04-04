package com.haulmont.taskman.core;

public interface HtmlToTextConverterService {
    String NAME = "taskman_HtmlToTextConverterService";

    String convert(String htmlText);
}