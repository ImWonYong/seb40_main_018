package project.danim.diary.mapper;

import org.mapstruct.Mapper;
import project.danim.diary.domain.Diary;
import project.danim.diary.dto.DiaryPatchDto;
import project.danim.diary.dto.DiaryPostDto;
import project.danim.diary.dto.DiaryResponseDto;

import java.util.List;


@Mapper(componentModel = "Spring")
public interface DiaryMapper {


    /*
      MemberId 추가 필요!!  -> PostDto @NotNull 주석 처리 함
     */
    default Diary diaryPostDtoToDiary(DiaryPostDto diaryPostDto, long memberId){
        Diary diary = new Diary(diaryPostDto.getTitle(),
                diaryPostDto.getQuestion(),
                diaryPostDto.getContent(),
                diaryPostDto.getWeather(),
                diaryPostDto.getArea(),
                diaryPostDto.getCity(),
                diaryPostDto.getCost(),
                0,
                memberId,
                diaryPostDto.getTravelDate());

        return diary;
    }

    default Diary diaryPatchDtoTodiary(DiaryPatchDto diaryPatchDto){
        Diary diary = new Diary();

        diary.setTitle(diaryPatchDto.getTitle());
        diary.setContent(diaryPatchDto.getContent());
        diary.setCost(diaryPatchDto.getCost());

        return diary;
    }



    /*
  MemberId 추가 필요!!
 */
    default DiaryResponseDto diaryToDiaryResponseDto(Diary diary, List<String> tags){
        DiaryResponseDto diaryResponseDto = new DiaryResponseDto();

        diaryResponseDto.setDiaryId(diary.getDiaryId());
        diaryResponseDto.setTitle(diary.getTitle());
        diaryResponseDto.setContent(diary.getContent());
        diaryResponseDto.setWeather(diary.getWeather());
        diaryResponseDto.setCity(diary.getCity());
        diaryResponseDto.setArea(diary.getArea());
        diaryResponseDto.setCost(diary.getCost());
        diaryResponseDto.setTags(tags);
        diaryResponseDto.setCreatedAt(diary.getCreatedAt());
        diaryResponseDto.setModifiedAt(diary.getModifiedAt());
        diaryResponseDto.setYear(diary.getTravelDate().getYear());
        diaryResponseDto.setMonth(diary.getTravelDate().getMonthValue());
        diaryResponseDto.setDay(diary.getTravelDate().getDayOfMonth());
        diaryResponseDto.setMemberId(diary.getMemberId());
        diaryResponseDto.setQuestion(diary.getQuestion());
        diaryResponseDto.setDiaryImages(diary.getDiaryImages());

        return diaryResponseDto;
    }

    List<DiaryResponseDto> diaryToCityResponseDtos(List<Diary> diaries);

}
