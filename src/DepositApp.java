import java.util.Scanner;

public class DepositApp {
    public static void main(String[] args) {
        //TODO build the DepositInfo object using data from the outside (args, file, ...)
        DepositInfo depositInfo = new DepositInfo("Лето-2022", 0.06);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите сумму вклада в рублях:");
            int initialAmount = scanner.nextInt();

            System.out.println("Введите срок вклада в годах:");
            int periodInYears = scanner.nextInt();

            final int simplePercentCalcCode = 1;
            final int capitalizationCalcCode = 2;
            System.out.println("Укажите код расчета по вкладу:");
            System.out.printf("\t%d - с обычным процентом%n", simplePercentCalcCode);
            System.out.printf("\t%d - с капитализацией%n", capitalizationCalcCode);
            int calcCode = scanner.nextInt();

            if (calcCode != simplePercentCalcCode && calcCode != capitalizationCalcCode) {
                System.out.println("Ошибка: указан неизвестный код расчета.");
                return;
            }

            System.out.printf(
                    "Результат по вкладу '%s': %.2f за %d лет превратятся в %.2f.%n",
                    depositInfo.getName(),
                    (double) initialAmount,
                    periodInYears,
                    depositInfo.calculateTotal(
                            initialAmount,
                            periodInYears,
                            calcCode == capitalizationCalcCode
                    )
            );
        }
    }
}
