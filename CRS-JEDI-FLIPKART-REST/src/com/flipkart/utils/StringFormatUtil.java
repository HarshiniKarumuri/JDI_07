package com.flipkart.utils;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class StringFormatUtil {

    public static <E> void printTabular(Logger logger, List<String> columnName, List<E> data, PrintTabularInterface fn) {
        logger.info(columnName.stream().map(name -> String.format("%-20s", name)).collect(Collectors.toList()));
        for(E row: data) {
            logger.info(fn.printTabular(row).stream().map(name -> String.format("%-20s", name)).collect(Collectors.toList()));
        }
        logger.info("\n");
    }
}
