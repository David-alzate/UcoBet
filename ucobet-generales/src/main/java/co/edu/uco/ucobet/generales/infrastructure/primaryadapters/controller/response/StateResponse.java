package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveStateDTO;

public class StateResponse {
    private List<String> mensajes;
    private List<RetrieveStateDTO> datos; 

    public StateResponse() {
        this.mensajes = new ArrayList<>();
        this.datos = new ArrayList<>();
    }

    public List<String> getMensajes() {
        return mensajes;
    }


    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }


    public List<RetrieveStateDTO> getDatos() {
        return datos;
    }

    public void setDatos(List<RetrieveStateDTO> datos) {
        this.datos = datos;
    }
}