package bo.edu.ucb.mscuentaatm.dto;

public class Card {
    private Integer card_Id;
    private Integer type_Id;
    private String type_card;

    public Card() {
    }

    public Card(Integer cardId) {
        this.card_Id = cardId;
    }


    public String getType_card() {
        return type_card;
    }

    public void setType_card(String type_card) {
        this.type_card = type_card;
    }

    
    public Integer getCardId() {
        return card_Id;
    }

    public void setCardId(Integer cardId) {
        this.card_Id = cardId;
    }

    public Integer getTypeId() {
        return type_Id;
    }

    public void setTypeId(Integer typeId) {
        this.type_Id = typeId;
    }

    @Override
    public String toString() {
        return "{" +
            " cardId='" + getCardId() + "'" +
            ", typeId='" + getTypeId() + "'" +
            "}";
    }
}
