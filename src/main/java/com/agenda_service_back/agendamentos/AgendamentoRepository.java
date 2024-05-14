package com.agenda_service_back.agendamentos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
}
