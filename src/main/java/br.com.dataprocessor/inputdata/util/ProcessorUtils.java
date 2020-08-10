package br.com.dataprocessor.inputdata.util;

import com.google.common.base.Splitter;

import java.util.List;

public class ProcessorUtils {

    public static List<String> slitLine(String data, Character delimitator){
        return  Splitter.on(delimitator)
                .trimResults()
                .omitEmptyStrings()
                .splitToList(data);
    }

    public static String removeColchetes(String data){
        data = data.replace("[","");
        data = data.replace("]","");
        return data;
    }
}
