package com.joao.musicsapi.controller;

import com.joao.musicsapi.document.Musics;
import com.joao.musicsapi.repository.MusicsRepository;
import com.joao.musicsapi.service.MusicsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.net.HttpURLConnection;

import static com.joao.musicsapi.constrans.MusicsConstant.MUSICS_ENDPOINT_LOCAL;


@RestController
@Slf4j
public class MusicsController {

    MusicsService musicsService;
    MusicsRepository musicsRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(MusicsController.class);

    public MusicsController (MusicsService musicsService, MusicsRepository musicsRepository){
        this.musicsService = musicsService;
        this.musicsRepository = musicsRepository;
    }

    @GetMapping(MUSICS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Musics> getAllItems() {
        log.info("requesting list off all musics");
        return musicsService.findAll();
    }

    @GetMapping(MUSICS_ENDPOINT_LOCAL+"/{id}")
    public Mono<ResponseEntity<Musics>> findByIdMusic(@PathVariable String id){
        log.info("requesting the music with id {}", id);
        return musicsService.findByIdMusic(id)
                .map((item) -> new ResponseEntity<>(item,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(MUSICS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Musics> createMusic(@RequestBody Musics music){
        log.info("a new music was created");
        return musicsService.save(music);
    }

    @DeleteMapping(MUSICS_ENDPOINT_LOCAL+"/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDMusic(@PathVariable String id){
        musicsService.deletebyIDMusic(id);
        log.info("deleting a hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
