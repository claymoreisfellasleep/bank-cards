package kz.study.debug.service;

import kz.study.debug.dto.CardDTO;
import kz.study.debug.mapper.CardMapper;
import kz.study.debug.model.Card;
import kz.study.debug.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public List<CardDTO> getCards(){
        return cardMapper.toDtoList(cardRepository.findAll());
    }

    public CardDTO addCard(CardDTO card){
        return cardMapper.toDto(cardRepository.save(cardMapper.toModel(card)));
    }

    public CardDTO getCard(Long id){
        return cardMapper.toDto(cardRepository.findById(id).orElse(new Card()));
    }

    public CardDTO updateCard(CardDTO card){
        return cardMapper.toDto(cardRepository.save(cardMapper.toModel(card)));
    }

    public void deleteCard(Long id){
        cardRepository.deleteById(id);
    }

}
