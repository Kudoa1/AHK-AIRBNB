package dds.airbn_ahk.Controllers;

import dds.airbn_ahk.entities.ubicaciones.Pais;
import dds.airbn_ahk.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {
    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public ResponseEntity<List<Pais>> generarPaises(){
        Pais argentina =  new Pais("Argentina");
        Pais brasil =  new Pais("Brasil");
        Pais uruguay =  new Pais("Uruguay");

        //GENERAR INSERT EN LA BD
        this.paisRepository.save(argentina);
        this.paisRepository.save(brasil);
        this.paisRepository.save(uruguay);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(List.of(argentina,brasil,uruguay));
    }
}
