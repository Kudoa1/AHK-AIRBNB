package dds.airbn_ahk.repositories;

import dds.airbn_ahk.entities.ubicaciones.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
