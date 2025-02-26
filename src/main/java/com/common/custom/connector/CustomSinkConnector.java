package com.common.custom.connector;

import com.common.custom.task.CustomSinkTask;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

import java.util.List;
import java.util.Map;

public class CustomSinkConnector extends SinkConnector {

    private Map<String, String> configProps;

    @Override
    public void start(Map<String, String> props) {
        this.configProps = props;
    }

    @Override
    public Class<? extends Task> taskClass() {
        return CustomSinkTask.class;  // Define a classe responsável pelo processamento
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        return List.of(configProps);
    }

    @Override
    public void stop() {
        // Código para parar o conector se necessário
    }

    @Override
    public ConfigDef config() {
        return new ConfigDef();
    }

    @Override
    public String version() {
        return "1.0";
    }
}
