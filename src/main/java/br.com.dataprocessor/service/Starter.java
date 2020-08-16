package br.com.dataprocessor.service;

import br.com.dataprocessor.facade.ProcessorFacade;
import br.com.dataprocessor.inputdata.extractor.DataExtractor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Starter {

    private static final Integer THREADS = 2;

    public void start(){

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(THREADS);

        DataExtractor.listAllFiles().forEach(file-> {
            ProcessorFacade processor = new ProcessorFacade();
            executor.execute(() -> {
                processor.process(file);
            });
        });
    }

}
