package com.joao.musicsapi.repository;

import com.joao.musicsapi.document.Musics;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MusicsRepository extends CrudRepository<Musics,String>{


}
