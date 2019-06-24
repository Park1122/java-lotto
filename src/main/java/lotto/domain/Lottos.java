package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int DEFAULT_PRICE = 1000;
    private final static int CANT_BUYABLE_COUNT = 0;
    
    private List<LottoNumbers> lottoNumbers;
    
    public Lottos() {
        this(new ArrayList<>());
    }
    
    public Lottos(final List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    
    public static int getBuyableCount(final int cashPayment) {
        final int buyableCount = cashPayment / DEFAULT_PRICE;
        if (buyableCount <= CANT_BUYABLE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
        }

        return buyableCount;
    }
    
    WinNumbersCount getWinNumbersCount(final WanLottoNumbers wanLottoNumbers) {
        WinNumbersCount winNumbersCount = new WinNumbersCount();
        lottoNumbers.forEach(lotto -> 
            winNumbersCount.addWinCount(wanLottoNumbers.getMatchedNumberCount(lotto))
        );
        return winNumbersCount;
    }
    
    public int getLottoSize() {
        return lottoNumbers.size();
    }
    
    @Override
    public String toString() {
        return (lottoNumbers + "").replace("[", "").replace("]", "");
    }
}
