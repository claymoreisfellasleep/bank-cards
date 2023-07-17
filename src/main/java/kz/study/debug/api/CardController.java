package kz.study.debug.api;

import kz.study.debug.dto.CardDTO;
import kz.study.debug.model.Card;
import kz.study.debug.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/card")
public class CardController {
    private final CardService cardService;

    @GetMapping(value = "/get-card-list")
    public List<CardDTO> getCourses(){
        return cardService.getCards();
    }

    @PostMapping(value = "/add-card")
    public CardDTO addCard(@RequestBody CardDTO card){
        return cardService.addCard(card);
    }


}
