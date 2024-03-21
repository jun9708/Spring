package kr.co.sboard.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageResponseDTO {

    private List<ArticleDTO> dtoList;
    private String cate;
    private int pg;
    private int size;
    private int total;
    private int startNo;
    private int start, end;
    private boolean prev, next;

    @Builder //생성자 작성
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<ArticleDTO> dtoList, int total){
        this.cate = pageRequestDTO.getCate(); 
        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        this.startNo = total - ((pg - 1) * size); //전체 페이지에서 1빼고 사이즈 구하기
        this.end = (int) (Math.ceil(this.pg / 10.0)) * 10;
        this.start = this.end - 9;

        int last = (int) (Math.ceil(total / (double) size));
        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }


}