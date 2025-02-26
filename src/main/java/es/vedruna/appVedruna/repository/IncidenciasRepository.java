package es.vedruna.appVedruna.repository;

import es.vedruna.appVedruna.model.Incidencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IncidenciasRepository extends MongoRepository<Incidencia, String> {

}
