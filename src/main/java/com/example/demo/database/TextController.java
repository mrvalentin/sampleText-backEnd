package com.example.demo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class TextController {

    @Autowired
    private TextRepository textRepository;

    @GetMapping("/fetchText")
    public Page<DAO> getAllTexts(Pageable pageable) {
        return textRepository.findAll(pageable);
    }

    @PostMapping("/saveText")
    public DAO createText(@Valid @RequestBody DAO text) {
        return textRepository.save(text);
    }

    @GetMapping("/fetchTextOne")
    public Optional<DAO> getTextById(long id) {
        Optional<DAO> dao = textRepository.findById(id);
        return dao;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/getText", method = RequestMethod.GET, produces = "application/json")
    public DAO getText(@RequestParam(required=false, defaultValue="") String text){

        DAO daoObject = new DAO(text);
        DAO savedDAO = createText(daoObject);
        Optional<DAO> daoOptional = getTextById(savedDAO.getId());
        return daoOptional.get();
    }
}
