package com.joao.musicsapi;

import com.joao.musicsapi.repository.MusicsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.joao.musicsapi.constrans.MusicsConstant.MUSICS_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class MusicsapiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	MusicsRepository musicsRepository;


	@Test
	public void getOneMusicById(){
		webTestClient.get().uri(MUSICS_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneMusicnotFound(){
		webTestClient.get().uri(MUSICS_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteMusic(){
		webTestClient.delete().uri(MUSICS_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}
}



