package com.te.mp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.mp.dto.ResponseDTO;
import com.te.mp.entity.MusicPlayer;
import com.te.mp.service.MusicPlayerServiceImpl;

@RestController
public class MusicController {
	@Autowired
	private MusicPlayerServiceImpl service;

//to search for a Music
	@GetMapping(path = "/search_a_song/{Song_ID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO Search_a_Song(@PathVariable Integer Song_ID) {
		ResponseDTO response = new ResponseDTO();
		MusicPlayer mp = service.findSong(Song_ID);
		response.setStatusCode(200);
		response.setMessage("Data Found");
		response.setData(mp);
		return response;
	}

// to getall musics
	@GetMapping(path = "show_all_songs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO Show_all_Songs() {
		ResponseDTO response = new ResponseDTO();
		List<MusicPlayer> allMusic = service.getAll();
		if (allMusic.isEmpty()) {
			response.setStatusCode(404);
			response.setMessage("no data found");
		} else {
			response.setStatusCode(200);
			response.setMessage("data found");
			response.setData(allMusic);
		}
		return response;
	}

//to get random music
	@GetMapping(path = "random_Song", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO random_Song() {
		ResponseDTO response = new ResponseDTO();
		MusicPlayer allMusic = service.findSong(20);
		response.setStatusCode(200);
		response.setMessage("data found");
		response.setData(allMusic);
		return response;
	}

//to create new music
	@PostMapping(path = "operate/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO createMusic(@RequestBody MusicPlayer newMusic) {
		ResponseDTO response = new ResponseDTO();
		MusicPlayer musicVar = service.createORUpdateSong(newMusic);
		if (musicVar.equals(null)) {
			response.setStatusCode(404);
			response.setMessage("could not save song");
		} else {
			response.setStatusCode(200);
			response.setMessage("Sussessfully added");
			response.setData(musicVar);
		}
		return response;
	}

//to update existing music
	@PutMapping(path = "/operate/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO updateMusic(@RequestBody MusicPlayer updatedMusic) {
		ResponseDTO response = new ResponseDTO();
		MusicPlayer updSong = service.createORUpdateSong(updatedMusic);
		if (updSong.equals(null)) {
			response.setStatusCode(404);
			response.setMessage("could not upadate song");
		} else {
			response.setStatusCode(200);
			response.setMessage("Sussessfully updated");
			response.setData(updSong);
		}
		return response;
	}

//to delete a music
	@DeleteMapping(path = "/operate/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO deleteMusic(@PathVariable Integer id) {
		ResponseDTO response = new ResponseDTO();
		service.deleteSong(id);
		response = Search_a_Song(id);
		if (response.getStatusCode() == 404) {
			response.setStatusCode(200);
			response.setMessage("Sussessfully deleted");
		} else {
			response.setStatusCode(404);
			response.setMessage("could not delete song");
		}
		return response;
	}
}
