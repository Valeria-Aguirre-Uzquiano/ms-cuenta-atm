package bo.edu.ucb.mscuentaatm.api;

import java.util.List;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.mscuentaatm.bl.AccountBl;
import bo.edu.ucb.mscuentaatm.dto.Card;


@RestController
@RequestMapping("/v1/api-account")
public class AccountControler {

    private AccountBl accountBl;
    
    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AccountControler.class);

    @Autowired
    public AccountControler(AccountBl accountBl) {
        this.accountBl = accountBl;
    }


    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Card> getAccount(@RequestParam Integer cardId){
        LOGGER.info("invocando metodo GET cuentas");
        List<Card> accountsList = accountBl.ListAccount(cardId);
        return accountsList;
    }

    @PostMapping(path ="/new_account", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus NewAccount(@RequestBody Card card){
        LOGGER.info("invocando metodo POST NUEVA CUENTA");
        LOGGER.info("{}",card);
        HttpStatus result = accountBl.createAccount(card);
        return result;
    }

    @PutMapping(path ="/account", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus NewCliente(@RequestBody Card card){
        LOGGER.info("invocando metodo PUT CAMBIAR CUENTA");
        LOGGER.info("{}",card);
        HttpStatus result = accountBl.updateAccount(card);
        return result;
    }
    
    
}
