package com.agenda_service_back.agendamentos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> getAllAgendamentos(){
        List<AgendamentoDTO> agendamentosDTO = agendamentoService.findAll();
        return ResponseEntity.ok(agendamentosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> getAgendamentoById(@PathVariable Long id){
        AgendamentoDTO agendamentoDTO = agendamentoService.findById(id);
        return ResponseEntity.ok(agendamentoDTO);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> createAgendamento(@Valid @RequestBody AgendamentoDTO agendamentoDTO){
        AgendamentoDTO createAgendamentoDTO = agendamentoService.create(agendamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAgendamentoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> updateAgendamento(@PathVariable Long id,
                                                        @Valid @RequestBody AgendamentoDTO agendamentoDto) {
        AgendamentoDTO updateAgendamentoDTO = agendamentoService.update(id, agendamentoDto);
        return ResponseEntity.ok(updateAgendamentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id){
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
