package be.simondebruijn.videoplatform.domain.videos.repositories;

import be.simondebruijn.videoplatform.domain.videos.Video;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VideoRepository {
    List<Video> findAll();

    Optional<Video> findByName(String name);

    Optional<Video> findById(UUID id);
}
