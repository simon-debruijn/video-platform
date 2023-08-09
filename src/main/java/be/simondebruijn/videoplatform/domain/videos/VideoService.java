package be.simondebruijn.videoplatform.domain.videos;

import be.simondebruijn.videoplatform.domain.videos.repositories.DatabaseVideoRepository;
import be.simondebruijn.videoplatform.domain.videos.repositories.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(DatabaseVideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Optional<Video> findByName(String name) {
        return videoRepository.findByName(name);
    }

    public Optional<Video> findById(UUID id) {
        return videoRepository.findById(id);
    }
}
