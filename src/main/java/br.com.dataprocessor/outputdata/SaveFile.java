package br.com.dataprocessor.outputdata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    private static String outputFile = System.getProperty("user.home")
            .concat("/data/out/out.done.dat");

    public static void saveFile(String data) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(data);
        writer.close();
    }
}

