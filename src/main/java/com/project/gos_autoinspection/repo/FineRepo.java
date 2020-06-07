package com.project.gos_autoinspection.repo;

import com.project.gos_autoinspection.domain.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepo extends JpaRepository<Fine, Long> {

}
