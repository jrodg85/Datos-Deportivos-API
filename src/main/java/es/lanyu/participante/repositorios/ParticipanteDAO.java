package es.lanyu.participante.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import es.lanyu.participante.Participante;

//@Repository
@RepositoryRestResource(path="participantes",
                        itemResourceRel="participante",
                        collectionResourceRel="participantes")
public interface ParticipanteDAO extends JpaRepository<Participante, String> {

    @RestResource(path="nombre")
    List<Participante> findByNombreIgnoreCaseContaining(String txt);

    @RestResource(exported=false)
    void deleteById(String id);

    @RestResource(exported=false)
    void delete(Participante entity);

    // Mejor ponerselo a todo lo que tenga que aplicarse
//    void deleteAll(Iterable<? extends Participante> entities);
//    ...

}
