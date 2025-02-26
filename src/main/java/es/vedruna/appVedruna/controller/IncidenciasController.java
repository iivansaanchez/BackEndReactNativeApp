package es.vedruna.appVedruna.controller;

import es.vedruna.appVedruna.model.Incidencia;
import es.vedruna.appVedruna.services.IncidenciaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proyecto01/incidencias")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class IncidenciasController {
    
    private final IncidenciaServiceImpl incidenciaServiceImpl;

    @PostMapping("/post")
    public Incidencia createIncidencia(@RequestBody Incidencia incidencia) {
        return incidenciaServiceImpl.crearIncidencia(incidencia);
    }
}
