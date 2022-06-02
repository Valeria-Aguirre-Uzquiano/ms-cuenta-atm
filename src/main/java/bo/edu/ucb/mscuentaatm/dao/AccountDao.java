package bo.edu.ucb.mscuentaatm.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.mscuentaatm.dto.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {
    private  DataSource dataSource;

    @Autowired
    public AccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Card> ListAccount(){
        List<Card> result = new ArrayList<>();
        String sql = "SELECT c.card_id, t.type_card " +
                    "FROM card c "+
                    "inner join type_Card t on (c.type_id = t.type_id);";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement param = conn.prepareStatement(sql);
        )
        {            
            ResultSet rs = param.executeQuery();
            while (rs.next()){
                Card card = new Card();
                card.setCardId(rs.getInt("card_id"));
                card.setType_card(rs.getString("type_card"));
                result.add(card);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public boolean createAccount(Card card){
        System.out.print(card.getCardId());
        boolean aux;
        String sql = "INSERT INTO public.card (card_id, type_id) VALUES(?, ?)";
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement param = conn.prepareStatement(sql);
        )
        {
            param.setInt(1, card.getCardId());
            param.setInt(2, card.getTypeId());
            param.executeUpdate();
            aux = true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return aux;
    }

    public boolean updateAccount(Card card){
        System.out.print(card.getCardId());
        boolean aux;
        String sql = "UPDATE public.card SET type_id = ? WHERE card_id = ?";
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement param = conn.prepareStatement(sql);
        )
        {
            param.setInt(1, card.getTypeId());
            param.setInt(2, card.getCardId());
            param.executeUpdate();
            aux = true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return aux;
    }
}
