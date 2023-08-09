package be.simondebruijn.videoplatform.domain.videos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Videos not found")
public class VideosNotFoundException extends RuntimeException {
}
