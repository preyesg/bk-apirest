package cl.preyesg.backend.aprirest.bkapirest.controllers;

import java.util.*;
import java.util.stream.Collectors;

import cl.preyesg.backend.aprirest.bkapirest.models.entity.Usuario;
import cl.preyesg.backend.aprirest.bkapirest.models.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    //Clave valida _%P/Z#$aDF%;/&T2wA1@
    @Autowired
    IUsuarioService service;

    @GetMapping("/usuarios")
    public List<Usuario> listar(){
        return service.findAll();
    }

    @PostMapping(value = "/usuario")
    public ResponseEntity<?> create(@Validated @RequestBody Usuario usuario, BindingResult bindingResult){

        Map<String, Object> response = new HashMap<>();
        Usuario user = null;
        try {
            if(bindingResult.hasErrors()){
                List<String> errors = bindingResult.getFieldErrors()
                                .stream()
                                .map(err ->  "El campo '" + err.getField() +"' " + err.getDefaultMessage())
                                .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }
             user = service.save(usuario);
        }
        catch (DataAccessException e){
            if(e instanceof DataIntegrityViolationException){
                response.put("Violacion de datos","El correo ya esta registrado");
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.put("Error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","Cliente creado con Exito!!!");
        response.put("usuario", user);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }


}
