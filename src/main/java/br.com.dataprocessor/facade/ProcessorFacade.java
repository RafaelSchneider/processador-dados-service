package br.com.dataprocessor.facade;

import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.outputdata.model.OutputData;
import br.com.dataprocessor.service.DataInputService;
import br.com.dataprocessor.service.DataOutputService;

import java.util.function.Function;


public class ProcessorFacade {

	private DataInputService dataInputService;
	private DataOutputService dataOutputService;
	private InputData inputData;
	private OutputData outputData;

	public ProcessorFacade(){
		dataInputService = new DataInputService();
		dataOutputService = new DataOutputService();
		inputData = new InputData();
		outputData = new OutputData();

	}
	public void process(){

		extractInputData()
				.andThen(processToOutputData(outputData))
				.andThen(saveOutputData())
				.apply(inputData);
	}

	private Function<InputData, InputData> extractInputData(){
		return (InputData inputData)->
				dataInputService.extractor(inputData);
	}

	private Function<InputData, OutputData> processToOutputData(OutputData outputData){
		return (InputData inputData) ->
			dataOutputService.processOutput(outputData, inputData);
	}

	private Function<OutputData, OutputData> saveOutputData(){
		return (OutputData outputData)->
				dataOutputService.save(outputData);
	}
}
 
