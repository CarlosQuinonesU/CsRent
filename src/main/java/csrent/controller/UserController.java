package csrent.controller;


import csrent.dto.UserDTO;
import csrent.model.user.User;
import csrent.repository.genericCRUD.CRUDMemory;
import csrent.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/user")
public class    UserController {
    @Autowired
    UserService service;
    CRUDMemory memory;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> users=service.getAll();
        if (users==null||users.isEmpty()){
            return ResponseEntity.ok("No hay usuarios para retornar");
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User user){
        if (service.existByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.FOUND).body("El Correo "+ user.getEmail()+" ya ha sido registrado, ingrese otro correo.");
        }
        User userCreated= service.add(user);
        if (userCreated!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un problema al crear el usuario.");
    }

    @PostMapping ("/register")
        public ResponseEntity<?> postRegisterUser(@Valid @RequestBody UserDTO userDTO, BindingResult result){

        if (result.hasErrors()){
            List<String> errores = new ArrayList<>();

            for (ObjectError error : result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errores);
        }

        User userCreated= service.add(new User());
        return ResponseEntity.status(201).body(userCreated);
    }

    @PutMapping
    public User putUser(@RequestBody User user){
        return service.update(user);
    }

    @PatchMapping
    public User patchUser(@RequestBody User user){
        return service.edit(user);
    }

    @DeleteMapping ("{id}")
    public User deleteUser (@PathVariable Integer id){
        return service.delete(id);
    }

    @GetMapping ("{id}")
    public User getUser (@PathVariable String email){
        return service.getByEmail(email);
    }



}
