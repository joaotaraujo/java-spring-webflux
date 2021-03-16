package com.joao.musicsapi.service;

import com.joao.musicsapi.document.Musics;
import com.joao.musicsapi.repository.MusicsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MusicsService {
    private final MusicsRepository musicsRepository;

    public MusicsService(MusicsRepository musicsRepository) {
        this.musicsRepository = musicsRepository;
    }

    public Flux<Musics> findAll(){
        return Flux.fromIterable(this.musicsRepository.findAll());
    }

    public Mono<Musics> findByIdMusic(String id){
        return Mono.justOrEmpty(this.musicsRepository.findById(id));
    }

    public Mono<Musics> save(Musics musics){
        return Mono.justOrEmpty(this.musicsRepository.save(musics));
    }

    public Mono<Boolean> deletebyIDMusic(String id){
        this.musicsRepository.deleteById(id);
        return Mono.just(true);
    }

}
