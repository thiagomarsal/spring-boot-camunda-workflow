package com.example;

import java.util.logging.Logger;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.StringValue;

@Named("logger")
public class LoggerDelegate implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String message = StringUtils.EMPTY;
		
		if (execution.hasVariable("process-message")) {
			StringValue stringValue = execution.getVariableTyped("process-message");
			message = stringValue.getValue();
		}
		
		StringBuilder logBuilder = new StringBuilder();
		logBuilder.append("\nLoggerDelegate invoked by \n");
		logBuilder.append(String.format("- processDefinitionId = %s\n", execution.getProcessDefinitionId()));
		logBuilder.append(String.format("- activityId = %s\n", execution.getCurrentActivityId()));
		logBuilder.append(String.format("- activityName = %s\n", execution.getCurrentActivityName().replaceAll("\n", " ")));
		logBuilder.append(String.format("- processInstanceId = %s\n", execution.getProcessInstanceId()));
		logBuilder.append(String.format("- businessKey = %s\n", execution.getProcessBusinessKey()));
		logBuilder.append(String.format("- executionId = %s\n", execution.getId()));
		logBuilder.append(String.format("- modelName = %s\n", execution.getBpmnModelInstance().getModel().getModelName()));
		logBuilder.append(String.format("- elementId = %s\n", execution.getBpmnModelElementInstance().getId()));
		logBuilder.append(String.format("- process-message = %s\n", message));
		
		LOGGER.info(logBuilder.toString());
	}
}