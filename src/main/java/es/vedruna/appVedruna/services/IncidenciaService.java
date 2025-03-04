package es.vedruna.appVedruna.services;

import java.util.List;

import es.vedruna.appVedruna.model.Incidencia;

public interface IncidenciaService {
    Incidencia crearIncidencia(Incidencia incidencia);
    List<Incidencia> obtenerTodasIncidencias();
}
