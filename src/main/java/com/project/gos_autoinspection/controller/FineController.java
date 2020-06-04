package com.project.gos_autoinspection.controller;


import com.project.gos_autoinspection.Exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("fines")
public class FineController {

    private int counter = 4;
    private List<Map<String, String>> fines = new ArrayList<Map<String,String>>(){{
        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "FirstMessage");}});
        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "SecondMessage");}});
        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "ThirdMessage");}});
    }};

    @GetMapping
    public List<Map<String, String>> list(){
        return fines;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id){
        return getFine(id);
    }

    private Map<String, String> getFine(@PathVariable String id) {
        return fines.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> fine){
        fine.put("id", String.valueOf(counter++));

        fines.add(fine);

        return fine;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> fine){
        Map<String, String> fineFromDb = getFine(id);

        fineFromDb.putAll(fine);
        fineFromDb.put("id", id);

        return fineFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> fine = getFine(id);

        fines.remove(fine);
    }
}
