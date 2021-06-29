package com.te.mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mp.dao.MusicPlayerRepository;
import com.te.mp.entity.MusicPlayer;
@Service
public class MusicPlayerServiceImpl implements MusicPlayerService {
	@Autowired
	private MusicPlayerRepository repository;
	
	public List<MusicPlayer> getAll() {
		return repository.findAll();
	}

	public MusicPlayer createORUpdateSong(MusicPlayer newSong) {
		return repository.saveAndFlush(newSong);
	}
	
	public void deleteSong(Integer id) {
		repository.deleteById(id);
	}
	public MusicPlayer findSong(Integer id) {
		return repository.findById(id).get();
	}
}
