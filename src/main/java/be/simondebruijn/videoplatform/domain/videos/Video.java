package be.simondebruijn.videoplatform.domain.videos;

import java.util.UUID;

public record Video(UUID id, String name) {
    public Video(String name) {
        this(UUID.randomUUID(), name);
    }
}
