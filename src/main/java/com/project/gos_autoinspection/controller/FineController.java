package com.project.gos_autoinspection.controller;


import com.project.gos_autoinspection.domain.Fine;
import com.project.gos_autoinspection.repo.FineRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("fines")
public class FineController {

    private final FineRepo fineRepo;

    @Autowired
    public FineController(FineRepo fineRepo) {
        this.fineRepo = fineRepo;
    }

    @GetMapping
    public List<Fine> list(){
        return fineRepo.findAll();
    }

    @GetMapping("{id}")
    public Fine getOne(@PathVariable("id") Fine fine){
        return fine;
    }

    @PostMapping
    public Fine create(@RequestBody Fine fine){
        fine.setCreationDate(LocalDateTime.now());
        return fineRepo.save(fine);
    }

    @PutMapping("{id}")
    public Fine update(@PathVariable("id") Fine fineFromDb,
                       @RequestBody Fine fine){
        BeanUtils.copyProperties(fine, fineFromDb, "id");

        return fineRepo.save(fineFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Fine fine){
        fineRepo.delete(fine);
    }
}
