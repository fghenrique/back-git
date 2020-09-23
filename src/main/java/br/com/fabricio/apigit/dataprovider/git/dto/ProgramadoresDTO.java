package br.com.fabricio.apigit.dataprovider.git.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramadoresDTO {

    private List<ProgramadorDTO> items;
    private String total_count;
    private String incomplete_results;

    public List<ProgramadorDTO> getItems() {
        return items;
    }

    public void setItems(List<ProgramadorDTO> items) {
        this.items = items;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(String incomplete_results) {
        this.incomplete_results = incomplete_results;
    }
}