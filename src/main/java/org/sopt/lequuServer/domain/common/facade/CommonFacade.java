package org.sopt.lequuServer.domain.common.facade;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.lequuServer.domain.book.service.BookService;
import org.sopt.lequuServer.domain.common.dto.response.PopularBookResponseDto;
import org.sopt.lequuServer.domain.common.dto.response.SplashDto;
import org.sopt.lequuServer.domain.note.repository.NoteRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CommonFacade {
    private final NoteRepository noteRepository;
    private final BookService bookService;

    public SplashDto getSplash() {
        return SplashDto.of(noteRepository.count());
    }

    public List<PopularBookResponseDto> getHome() {

        return bookService.getPopularBooks()
            .stream().map(PopularBookResponseDto::of)
            .toList();
    }
    // 레큐북 정렬된 것을 가져오기

    public String getLottie(){
        try {
            // src/main/resources 디렉토리의 data.json 파일 경로 읽기
            ClassPathResource resource = new ClassPathResource("lottie.json");
            InputStream inputStream = resource.getInputStream();

            return StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("IOE Error: {e}", e);
        }
        return null;
    }
}
