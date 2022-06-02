package bo.edu.ucb.mscuentaatm.repository;

import bo.edu.ucb.mscuentaatm.entity.TypeId;
import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.mscuentaatm.entity.Card;
import bo.edu.ucb.mscuentaatm.entity.TypeCard;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Card, Integer>{

    @Query(value = "select new bo.edu.ucb.mscuentaatm.entity.TypeId(c.cardId, c.typeId.typeId) from Card c")
    public List<TypeId> obtenerType();
    
    @Query(value = "insert into Card (card_id, type_id) values (?1, ?2)", nativeQuery = true)
    public String createCard(Integer card_id,TypeCard typeCard);
}
