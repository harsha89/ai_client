/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AI;

import GraphicOb.CoinPile;

/**
 *
 * @author Harsha
 */
public class CoinHandler {
private CoinPile coin;
private int length;

    /**
     * @return the coin
     */
    public CoinPile getCoin() {
        return coin;
    }

    /**
     * @param coin the coin to set
     */
    public void setCoin(CoinPile coin) {
        this.coin = coin;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }
}
