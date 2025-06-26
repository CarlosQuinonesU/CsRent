package csrent.controller.space;

import java.util.List;
import java.util.Optional;

import csrent.model.space.Space;
import csrent.repository.genericCRUD.CRUDMemory;
import csrent.service.space.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/space")
public class SpaceController {

    @Autowired
    SpaceService service;
    CRUDMemory memory;
    //private ArrayList<Space> spaces;


    //public SpaceController(){
        //spaces.add(new Space(1, "Grabación IN",122,"Cabina de grabación"));
        //spaces.add(new Space(2, "TV Group",100,"Estudio de televisión"));
        //spaces.add(new Space(3, "Ballet Vero",50,"Salón de ballet"));
        //spaces.add(new Space(4, "Música Quiñones",50,"Estudio de música"));
   //}



//    @GetMapping
//    public ResponseEntity<List<Space>> getAll(){
//        List<Space> spaces = service.getAll();
//        if (spaces==null || spaces.isEmpty()){
//            return ResponseEntity.noContent().build();
//
//        }
//        return ResponseEntity.ok(spaces);
//    }

    //Metodo para agregar un elemento al array
    @PostMapping
    public ResponseEntity<?> postSpace(@RequestBody Space space){
        if (service.existsByName(space.getName())){
            return ResponseEntity.status(HttpStatus.FOUND).body("El espacio con el nombre "+space.getName()+" ya ha sido regestrado.");
        }
        Space spaceCreated=service.add(space);
        if (spaceCreated!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(spaceCreated);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un problema al crear el espacio.");
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Space> spaces = service.getAll();
        if (spaces==null || spaces.isEmpty()){
            return ResponseEntity.ok("No hay espcios creativos para retornar");
        }
        return ResponseEntity.ok(spaces);
    }

    // Actualizar un elemento de un arraylist
    @PutMapping
    public ResponseEntity<?> putSpace(@RequestBody Space space){
        if (service.existsById(space.getId())){
            return ResponseEntity.ok(service.update(space));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con el id: "+space.getId()+" no se encuentra registrado.");
    }

    //Metodo que reciba un objeto y verifique cuales atributos traen información
    // solo modifica los atributos que corrresponden
    @PatchMapping
    public ResponseEntity<?> patchSpace(@RequestBody Space space){
        if (service.existsById(space.getId())){
            return ResponseEntity.ok(service.edit(space));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con el id: "+space.getId()+" no se encuentra registrado.");
  }

    //Metodo para eliminar un espacio por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpace(@PathVariable Integer  id){
        if (service.existsById(id)){
            return ResponseEntity.ok(service.delete(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id: "+id+" no corresponde a nigun espacio.");
    }

    // Metodo para retornar una objeto por id
    @GetMapping ("/{id}")
    public ResponseEntity<?> getSpace(@PathVariable Integer id){
        if (service.existsById(id)){
            return  ResponseEntity.ok(service.search(id)) ;
        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con Id "+id+" no se encuentra registrado.");
//        return ResponseEntity.ok("El espacio con Id "+id+" no se encuentra registrado.");
        return ResponseEntity.notFound().build();
    }













}
