package kz.study.debug.repository;

import jakarta.transaction.Transactional;
import kz.study.debug.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CardRepository extends JpaRepository<Card, Long> {

}
