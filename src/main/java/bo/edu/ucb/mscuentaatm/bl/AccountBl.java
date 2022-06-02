package bo.edu.ucb.mscuentaatm.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import bo.edu.ucb.mscuentaatm.dao.AccountDao;
import bo.edu.ucb.mscuentaatm.dto.Card;

@Service
public class AccountBl {
    public final AccountDao accountDao;

    @Autowired
    public AccountBl( AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Card> ListAccount(){
        return accountDao.ListAccount();
    }

    public HttpStatus createAccount(Card card){
        if (accountDao.createAccount(card)) {
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }
    public HttpStatus updateAccount(Card card){
        if (accountDao.updateAccount(card)) {
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }
}
