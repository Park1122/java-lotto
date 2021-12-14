package lotto.controller;

import lotto.domain.BonusBall;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.factory.LottoFactory;
import lotto.domain.lotto.Lotto;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Lottery {

    public void draw() {
        Price price = Price.of(InputView.questionPrice());
        LottoCount manualCount = LottoCount.of(InputView.questionManualCount());

        // 입력 정보
        InputInfo inputInfo = new InputInfo(price, manualCount);
        List<String> inputManualLottos = InputView.questionManualInput(inputInfo.getManualCount());

        Lottos lottos = LottoFactory.lottos(price, inputManualLottos);

        // 입력 정보 받기
        inputInfo.printInfo();

        ResultView.printLottos(lottos);

        winner(lottos);
    }



    private void winner(Lottos lottos) {
        String answerText = InputView.questionAnswer();
        String bonusBall = InputView.questionBonus();
        BonusBall bonus = BonusBall.of(bonusBall);
        Lotto answer = LottoFactory.newInstance(answerText);
        ResultView resultView = new ResultView(lottos, answer, bonus);
        resultView.printResult();
    }

}
