package es.vedruna.appVedruna.controller;

import es.vedruna.appVedruna.model.Incidencia;
import es.vedruna.appVedruna.services.IncidenciaServiceImpl;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proyecto01/incidencias")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class IncidenciasController {

    private final IncidenciaServiceImpl incidenciaServiceImpl;

    @GetMapping()
    public List<Incidencia> getAllIncidencias() {
        return incidenciaServiceImpl.obtenerTodasIncidencias();
    }

    @PostMapping("/post")
    public Incidencia createIncidencia(@RequestBody Incidencia incidencia) {
        return incidenciaServiceImpl.crearIncidencia(incidencia);
    }
}
