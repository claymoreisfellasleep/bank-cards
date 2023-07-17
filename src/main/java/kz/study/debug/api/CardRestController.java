package kz.study.debug.api;

import kz.study.debug.dto.CardDTO;
import kz.study.debug.model.Card;
import kz.study.debug.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/card")
@RequiredArgsConstructor
public class CardRestController {
    private final CardService cardService;

    @GetMapping
    public List<CardDTO> cardList(){
        return cardService.getCards();
    }

    @GetMapping(value = "{id}")
    public CardDTO getCard(@PathVariable(name = "id") Long id){
        return cardService.getCard(id);
    }

    @PostMapping
    public CardDTO addCard(@RequestBody CardDTO card){
        return cardService.addCard(card);
    }

    @PutMapping
    public CardDTO updateCard(@RequestBody CardDTO card){
        return cardService.updateCard(card);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCard(@PathVariable(name = "id") Long id){
        cardService.deleteCard(id);
    }
}
