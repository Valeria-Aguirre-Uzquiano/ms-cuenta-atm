package bo.edu.ucb.mscuentaatm.entity;

public class TypeId {

    private int cardId;
    private int typeId;

    public TypeId(int cardId, int typeId) {
        this.cardId = cardId;
        this.typeId = typeId;
    }
    public TypeId(){

    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
