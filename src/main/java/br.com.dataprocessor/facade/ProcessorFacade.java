package br.com.dataprocessor.facade;

import br.com.dataprocessor.inputdata.model.InputDataModel;
import br.com.dataprocessor.outputdata.model.OutputDataModel;
import br.com.dataprocessor.service.DataInputService;
import br.com.dataprocessor.service.DataOutputService;

import java.util.function.Function;


public class ProcessorFacade {


	private DataInputService dataInputService;
	private DataOutputService dataOutputService;
	private InputDataModel inputDataModel;
	private OutputDataModel outputDataModel;

	public ProcessorFacade(){
		dataInputService = new DataInputService();
		dataOutputService = new DataOutputService();
		inputDataModel = new InputDataModel();
		outputDataModel = new OutputDataModel();

	}
	public void process(){

		extractInputData()
				.andThen(processToOutputData(outputDataModel))
				.andThen(saveOutputData())
				.apply(inputDataModel);
	}

	private Function<InputDataModel, InputDataModel> extractInputData(){
		return (InputDataModel inputDataModel)->
				dataInputService.extractor(inputDataModel);
	}

	private Function<InputDataModel, OutputDataModel> processToOutputData(OutputDataModel outputDataModel){
		return (InputDataModel inputDataModel) ->
			dataOutputService.processOutput(outputDataModel, inputDataModel);
	}

	private Function<OutputDataModel, OutputDataModel> saveOutputData(){
		return (OutputDataModel outputDataModel)->
				dataOutputService.save(outputDataModel);
	}
}
 
