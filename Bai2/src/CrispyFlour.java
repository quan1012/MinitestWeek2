import java.time.LocalDate;

public class CrispyFlour extends  Material implements MaterialManagement.Discount{
    private int quantity;

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return getQuantity()*getCost();
    }

    @Override
    public LocalDate getExxpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    public static void main(String[] args) {

    }

    @Override
    public double getRealMoney() {
        long daysBetween= getManufacturingDate().toEpochDay()-LocalDate.now().toEpochDay();
        if(daysBetween <=120 && daysBetween > 60) {
            return getAmount()*0.8;
        }
        else if (daysBetween <=60 && daysBetween > 0 ) return getAmount()*0.6;
        else if (daysBetween<0) return 0;
        else return getAmount()*0.95;
    }
}
