package com.flav.trailers.context.trailers.movies.domain.valueObjects;

import com.flav.trailers.context.trailers.movies.domain.exceptions.ErrorArgumentException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
public class StringTypeUrlVO {

    private final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";
    private final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private String value;

    public StringTypeUrlVO(String value) {
        this.validString(value);
        this.value = value;
    }

    private void validString(String value) {
        Matcher matcher = URL_PATTERN.matcher(value);

        if(!matcher.matches()) {
            throw new ErrorArgumentException("the image and video fields must be a string with a valid url format (http://domino.com)", HttpStatus.BAD_REQUEST);
        }
    }

}
