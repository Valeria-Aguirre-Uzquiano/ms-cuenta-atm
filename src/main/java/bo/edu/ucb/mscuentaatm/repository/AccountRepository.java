package bo.edu.ucb.mscuentaatm.repository;

import bo.edu.ucb.mscuentaatm.entity.TypeId;
import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.mscuentaatm.entity.Card;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Card, Integer>{

    @Query(value = "select new bo.edu.ucb.mscuentaatm.entity.TypeId(c.cardId, c.typeId.typeId) from Card c")
    public List<TypeId> obtenerType();
    
}
