package org.sopt.lequuServer.domain.common.controller;

import io.sentry.Sentry;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.lequuServer.domain.common.dto.response.PopularBookResponseDto;
import org.sopt.lequuServer.domain.common.dto.response.SplashDto;
import org.sopt.lequuServer.domain.common.facade.CommonFacade;
import org.sopt.lequuServer.global.common.dto.ApiResponse;
import org.sopt.lequuServer.global.exception.enums.SuccessType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/common")
public class CommonController {

    private final CommonFacade commonFacade;

    @GetMapping("/splash")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<SplashDto> getSplash() {
        return ApiResponse.success(SuccessType.GET_SPLASH_SUCCESS, commonFacade.getSplash());
    }

    @GetMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<PopularBookResponseDto>> getHome() {
        return ApiResponse.success(SuccessType.GET_HOME_SUCCESS, commonFacade.getHome());
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> sentryTest() {
        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Sentry.captureException(e);
        }
        return null;
    }
}

