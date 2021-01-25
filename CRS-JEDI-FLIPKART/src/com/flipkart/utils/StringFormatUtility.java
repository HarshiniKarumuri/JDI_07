package com.flipkart.utils;

import org.apache.log4j.Logger;
import java.util.List;


public class StringFormatUtility {

    public static final Logger logger = Logger.getLogger(StringFormatUtility.class);

    public static void simpleTable(List<String> columnName, List<List<String>> data) {
        logger.info(String.format("| %-30s |", columnName));
        for(List<String> row: data) {
            logger.info(String.format("| %-30s |", row));
        }
    }
}
