package org.sopt.lequuServer.domain.common.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.sopt.lequuServer.domain.common.dto.response.PopularBookResponseDto;
import org.sopt.lequuServer.domain.common.dto.response.SplashDto;
import org.sopt.lequuServer.global.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

@Tag(name = "Common", description = "홈 & 스플래시 API")
public interface CommonApi {

    @io.swagger.v3.oas.annotations.responses.ApiResponse(
        responseCode = "200",
        description = "스플래시 조회에 성공했습니다.",
        content = @Content(schema = @Schema(implementation = SplashDto.class))
    )
    @Operation(summary = "스플래시 조회")
    ResponseEntity<ApiResponse<SplashDto>> getSplash();

    @io.swagger.v3.oas.annotations.responses.ApiResponse(
        responseCode = "200",
        description = "홈 화면 조회에 성공했습니다.",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = PopularBookResponseDto.class)))
    )
    @Operation(summary = "홈 조회")
    ResponseEntity<ApiResponse<List<PopularBookResponseDto>>> getHome();

    @Hidden
    ResponseEntity<ApiResponse<?>> test();

    @io.swagger.v3.oas.annotations.responses.ApiResponse(
        responseCode = "200",
        description = "로띠 조회에 성공했습니다.",
        content = @Content(schema = @Schema(implementation = String.class))
    )
    @Operation(summary = "로띠 json 조회")
    ResponseEntity<ApiResponse<String>> getLottie();
}
