package com.agenda_service_back.prestadores;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestadores")
public class PrestadorController {
    @Autowired
    private PrestadorService prestadorService;

    @GetMapping
    public ResponseEntity<List<PrestadorDTO>> getAllPrestadors(){
        List<PrestadorDTO> prestadorsDTO = prestadorService.findAll();
        return ResponseEntity.ok(prestadorsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorDTO> getPrestadorById(@PathVariable Long id){
        PrestadorDTO prestadorDTO = prestadorService.findById(id);
        return ResponseEntity.ok(prestadorDTO);
    }

    @PostMapping
    public ResponseEntity<PrestadorDTO> createPrestador(@Valid @RequestBody PrestadorDTO prestadorDTO){
        PrestadorDTO createPrestadorDTO = prestadorService.create(prestadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPrestadorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestadorDTO> updatePrestador(@PathVariable Long id,
                                                      @Valid @RequestBody PrestadorDTO prestadorDto) {
        PrestadorDTO updatePrestadorDTO = prestadorService.update(id, prestadorDto);
        return ResponseEntity.ok(updatePrestadorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable Long id){
        prestadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
