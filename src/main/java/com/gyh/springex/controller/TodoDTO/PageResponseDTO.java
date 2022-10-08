package com.gyh.springex.controller.TodoDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
//클래스 이름 뒤에 <E>를 사용하는게 Generic 한 방법이다.
//이 클래스는 가상의 클래스 E를 사용하게 된다. 이렇게하면 클래스의 형태를 하나로 정해둔게 아니기 때문에
//인스턴스를 만들때 형을 지정해주면 그 형태의 클래스로 사용할수 있다.
//자바 제네릭 클래스에 대해 더 알아보도록
@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;
    private boolean prev;
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int) (Math.ceil(this.page / 10.0)) * 10;
        this.start = end - 9;
        int last = (int) Math.ceil(total / (double) size);
        //end가 last 보다 크면 last이고 아니면 end
        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
