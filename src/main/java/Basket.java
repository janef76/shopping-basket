import java.util.ArrayList;

public class Basket {

    ArrayList<Item> items;
    double discount = 0.9;
    double cardDiscount = 0.98;

    public Basket() {
        this.items = new ArrayList<>();
    }


    public int countItems() {
        return items.size();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void emptyAll() {
        for (int i = 0; i <= countItems() + 1; i++) {
            items.remove(0);
        }
    }

    public double getSubTotal() {
        ArrayList<Item> checkForBOGOF = new ArrayList<>();
        double total = 0;
        for (Item item: items) {
            if (checkForBOGOF.contains(item) != items.contains(item)) {
                checkForBOGOF.add(item);
                total += item.getPrice();
            }
            else {
                checkForBOGOF.remove(item);
            }
        }
        return total;
    }

    public double getDiscountedTotal() {
        double subTotal = getSubTotal();
        if (subTotal > 20) {
            return subTotal * discount;
        }
        return subTotal;
    }

    public double hasDiscountCard() {
        return getDiscountedTotal() * cardDiscount;
    }

    public double hasNoDiscountCard() {
        return getDiscountedTotal();
    }

}

//    public double getSubTotal() {
//        ArrayList<Item> checkForBOGOF = new ArrayList<>();
//        double total = 0;
//        for (Item item: items) {
//            if (checkForBOGOF.contains(item) != items.contains(item)) {
//                checkForBOGOF.add(item);
//                total += item.getPrice();
//            }
////            else {
////                checkForBOGOF.remove(item);
////            }
//        }
//        return total;
//    }