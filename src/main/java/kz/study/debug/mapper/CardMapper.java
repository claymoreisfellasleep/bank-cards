package kz.study.debug.mapper;

import kz.study.debug.dto.CardDTO;
import kz.study.debug.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

//    Если надо будет поменять меняешь здесь, пусть стоит
//    @Mapping(source = "name", target = "title")
    CardDTO toDto(Card card);
    Card toModel(CardDTO cardDTO);

    List<CardDTO> toDtoList(List<Card> cardList);
    List<Card> toModelList(List<CardDTO> cardList);

}
