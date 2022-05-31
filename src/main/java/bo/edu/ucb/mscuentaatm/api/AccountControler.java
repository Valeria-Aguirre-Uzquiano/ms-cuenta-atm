package bo.edu.ucb.mscuentaatm.api;

import java.util.List;

import bo.edu.ucb.mscuentaatm.entity.TypeId;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.mscuentaatm.entity.Card;
import bo.edu.ucb.mscuentaatm.repository.AccountRepository;


@RestController
@RequestMapping("/v1/api-account")
public class AccountControler {
    
    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AccountControler.class);

    private AccountRepository accountRepository;

    public AccountControler(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<List<TypeId>> getAccounts(){
        LOGGER.info("invocando metodo GET cuentas");
        List<TypeId> accountsList =  accountRepository.obtenerType();
        return new ResponseEntity<>(accountsList, HttpStatus.OK);
    }
    
}
