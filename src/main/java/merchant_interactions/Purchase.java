package merchant_interactions;

import character.Player;
import inventory.*;

public class Purchase {
    /**
     * Use case for Purchasables
     */

    private Equipment item;
    private Player steve;

    public Purchase(Equipment item, Player player) {
        this.item = item;
        this.steve = player;
    }

    /**
     * Returns the money left after the item is processed by merchant_interactions.Merchant.
     * If the number is negative, the balance is not enough to afford said upgrade.
     */
    public int checkAfford(int balance) {
        return balance - item.getPrice();
    }

    public boolean purchaseCheck (){
        int tempBalance = this.checkAfford(steve.getInventory().getCoins());
        if (tempBalance >= 0){
            item.upgrade();
            steve.getInventory().setCoins(tempBalance);
            return true;
        }
        return false;
    }

}
