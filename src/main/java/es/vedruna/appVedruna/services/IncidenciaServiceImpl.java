package es.vedruna.appVedruna.services;

import es.vedruna.appVedruna.model.Incidencia;
import es.vedruna.appVedruna.repository.IncidenciasRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncidenciaServiceImpl implements IncidenciaService{
 
    private final IncidenciasRepository incidenciasRepository;

    private final EmailService emailService;
    @Override
    public Incidencia crearIncidencia(Incidencia incidencia) {
        Incidencia nuevaIncidencia = incidenciasRepository.save(incidencia);

        String destinatario = "sansaniva357@gmail.com";
        // Configurar el correo
        String asunto = "📌 Nueva Incidencia Reportada - " + incidencia.getTitulo();

        String mensaje = "Estimado/a,\n\n" +
                "Le informamos que se ha registrado una nueva incidencia en el sistema del **Centro Sta. Joaquina Vedruna**. A continuación, le proporcionamos los detalles:\n\n" +
                "**Número de Equipo:** " + incidencia.getNumeroEquipo() + "\n" +
                "**Título:** " + incidencia.getTitulo() + "\n" +
                "**Descripción:** " + incidencia.getDescripcion() + "\n" +
                "**Fecha de Reporte:** " + incidencia.getFecha() + "\n\n" +
                "Nuestro equipo de soporte atenderá esta incidencia a la mayor brevedad posible. Para cualquier consulta adicional, no dude en ponerse en contacto con nosotros.\n\n" +
                "Atentamente,\n" +
                "**Equipo de Soporte Técnico**\n" +
                "Centro Sta. Joaquina Vedruna";

        // Enviar correo
        emailService.enviarCorreo(destinatario,asunto, mensaje);


        return nuevaIncidencia;
    }

        @Override
    public List<Incidencia> obtenerTodasIncidencias() {
        return incidenciasRepository.findAll();
    }
}
