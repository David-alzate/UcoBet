package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;
import java.util.List;

public class CiudadResponse {
    private List<String> mensajes;

    public CiudadResponse() {
        this.mensajes = new ArrayList<>();
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}