package be.simondebruijn.videoplatform.domain.videos;

import be.simondebruijn.videoplatform.domain.videos.dtos.GetVideoResponse;
import be.simondebruijn.videoplatform.domain.videos.dtos.GetVideosResponse;
import be.simondebruijn.videoplatform.domain.videos.exceptions.VideoNotFoundException;
import be.simondebruijn.videoplatform.domain.videos.exceptions.VideosNotFoundException;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("videos")
public class VideoController
{
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/")
    public GetVideosResponse getVideos(@Nullable @RequestParam String name) {
        if (name == null || name.isEmpty()) {
            var videos = this.videoService.findAll();
            return new GetVideosResponse(videos, videos.size());
        }

        var video = this.videoService.findByName(name)
                .orElseThrow(VideosNotFoundException::new);

        return new GetVideosResponse(List.of(video), 1);
    }

    @GetMapping("/{id}")
    public GetVideoResponse getVideoById(@PathVariable String id) {
        var video = this.videoService.findById(UUID.fromString(id))
                .orElseThrow(VideoNotFoundException::new);

        return new GetVideoResponse(video);
    }
}
