package com.te.mp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.mp.entity.MusicPlayer;
@Repository
public interface MusicPlayerRepository extends JpaRepository<MusicPlayer, Integer> {

}
