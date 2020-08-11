package br.com.dataprocessor.inputdata.extractor;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class DataExtractor {

    public static Stream<String> extractDataFromArchive(String inputPath) {
        Stream<String> stream = null;
        try {

            return Files.lines(Paths.get(inputPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static List<String> listAllFiles(){
        try {

            return  Files.walk(Paths.get( System.getProperty("user.home").concat("/data/in")))
                    .map(Path::toString)
                    .filter(path -> ! path.endsWith("/in"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

