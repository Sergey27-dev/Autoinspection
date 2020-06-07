package com.project.gos_autoinspection.repo;

import com.project.gos_autoinspection.domain.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepo extends JpaRepository<Usr, Long> {
    Usr findByUsername(String username);
}
