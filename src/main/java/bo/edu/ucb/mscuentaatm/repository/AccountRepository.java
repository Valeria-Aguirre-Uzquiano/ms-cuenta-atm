package bo.edu.ucb.mscuentaatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.mscuentaatm.entity.Card;

public interface AccountRepository extends JpaRepository<Card, Integer>{
    
}
