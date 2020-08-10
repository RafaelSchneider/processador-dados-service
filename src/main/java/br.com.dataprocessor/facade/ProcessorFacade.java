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
	public void processaDados(){

		extrairDados()
				.andThen(processarDados(outputDataModel))
				.andThen(gravarDados())
				.apply(inputDataModel);
	}

	private Function<InputDataModel, InputDataModel> extrairDados(){
		return (InputDataModel inputDataModel)->
				dataInputService.extractor(inputDataModel);
	}

	private Function<InputDataModel, OutputDataModel> processarDados(OutputDataModel outputDataModel){
		return (InputDataModel inputDataModel) ->
			dataOutputService.processaSaida(outputDataModel, inputDataModel);
	}

	private Function<OutputDataModel, OutputDataModel> gravarDados(){
		return (OutputDataModel outputDataModel)->
				dataOutputService.save(outputDataModel);
	}
}
 
