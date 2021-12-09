package com.bestelling.bestelling.infrastructure.driver.web;

import com.bestelling.bestelling.core.application.query.BestellingQueryHandler;
import com.bestelling.bestelling.core.domain.Adres;
import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.domain.BestellingId;
import com.bestelling.bestelling.core.domain.Status;
import com.bestelling.bestelling.core.ports.storage.BestellingRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/bestelling")
public class BestellingController {
    private final BestellingQueryHandler service;
    public BestellingController(BestellingQueryHandler service) {
        this.service = service;
    }

    @GetMapping
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping("/test")
    public List<Bestelling> testGet(){
        Adres Atest = new Adres("teststraat", "1234AB");
        BestellingId id = new BestellingId(1);
        Bestelling Btest = new Bestelling(id, Status.INBEHANDELING, (float) 1.00, Atest, "Bob");

        //service.save(Btest);

        List<Bestelling> toreturn = service.getAll();

        return toreturn;
    }
}
