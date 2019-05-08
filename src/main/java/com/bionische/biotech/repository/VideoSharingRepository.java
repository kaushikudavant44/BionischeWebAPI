package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.VideoSharing;

public interface VideoSharingRepository extends JpaRepository<VideoSharing, Integer>{

	
	VideoSharing save(VideoSharing videoSharing);
	VideoSharing findByVideoId(int videoId);
}
