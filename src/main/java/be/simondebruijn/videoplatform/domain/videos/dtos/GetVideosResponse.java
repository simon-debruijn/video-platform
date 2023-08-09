package be.simondebruijn.videoplatform.domain.videos.dtos;

import be.simondebruijn.videoplatform.domain.videos.Video;

import java.util.List;

public record GetVideosResponse(List<Video> videos, Integer totalItems) {
}
