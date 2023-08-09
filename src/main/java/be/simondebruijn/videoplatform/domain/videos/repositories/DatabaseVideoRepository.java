package be.simondebruijn.videoplatform.domain.videos.repositories;

import be.simondebruijn.videoplatform.domain.videos.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DatabaseVideoRepository implements VideoRepository {
    private final List<Video> videos;

    public DatabaseVideoRepository() {
        this.videos = new ArrayList<>(
                List.of(
                        new Video("Mission Impossible"),
                        new Video("Oppenheimer")
                )
        );
    }

    @Override
    public List<Video> findAll() {
        return this.videos;
    }

    @Override
    public Optional<Video> findByName(String name) {
        return this.videos.stream()
                .filter(it -> it.name().equals(name))
                .findFirst();
    }

    @Override
    public Optional<Video> findById(UUID id) {
        return this.videos.stream()
                .filter(it -> it.id().equals(id))
                .findFirst();
    }
}
