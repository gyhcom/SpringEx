package com.gyh.springex.controller.TodoDTO;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class PageRequestDTO {
    private String link;
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size =10;

    public int getSkip(){
        return (page - 1) * 10;
    }

    public String getLink(){
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);

        if(finished){
            builder.append("&finished=on");
        }

        if(types != null && types.length > 0){
            for(int i = 0; i < types.length; i++){
                builder.append("&types=" + types[i]);
            }
        }

        if (keyword != null) {
            try{
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }

        if (from != null) {
            builder.append("&from=" + from.toString());
        }
        if (to != null) {
            builder.append("&to=" + to.toString());
        }
        return builder.toString();
    }

    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    public boolean checkType(String type){
        if (types == null || types.length == 0) {
            return false;
        }
        //더블콜론과 람다를 봐야 한다... 어렵다 람다.
        return Arrays.stream(types).anyMatch(type :: equals);
    }
}
