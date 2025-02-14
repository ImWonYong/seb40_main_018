package project.danim.diary.dto;


import lombok.Getter;
import lombok.Setter;
import project.danim.tag.domain.Tag;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DiaryResponseDto {
    private long diaryId;
    private String title;
    private String content;
    private String weather;
    private String city;
    private String area;
    private String question;
    private List<String> tags;
    private List<String> diaryImages;
    private int cost;
    private long memberId;
    private long likeCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int year;
    private int month;
    private int day;
}
