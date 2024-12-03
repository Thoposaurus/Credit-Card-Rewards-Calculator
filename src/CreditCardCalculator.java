import java.util.Scanner;

public class CreditCardCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the name of the credit card you wish to calculate");
        String cardName = scanner.nextLine();

        System.out.println("please enter the annual fee of the " + cardName);
        System.out.println("if there is no annual fee, please enter 0");
        int annualFee = scanner.nextInt();

        System.out.println("please enter the restaurant rewards percentage");
        double input = scanner.nextDouble();
        double restaurantRewards = percentageConverter(input);

        System.out.println("please enter the grocery rewards percentage");
        input = scanner.nextDouble();
        double groceryRewards = percentageConverter(input);

        System.out.println("please enter the travel rewards percentage");
        input = scanner.nextDouble();
        double travelRewards = percentageConverter(input);

        System.out.println("please enter the gas rewards percentage");
        input = scanner.nextDouble();
        double gasRewards = percentageConverter(input);

        System.out.println("please enter all other spending rewards percentage");
        input = scanner.nextDouble();
        double otherRewards = percentageConverter(input);

        double restaurantSpend = 326.0;
        double grocerySpend = 655.0;
        double travelSpend = 326.0;
        double gasSpend = 220.0;
        double otherSpend = 100.0;


        //calculate monthly rewards
        double monthlyRestaurantRewards = calculateMonthlyRewards(restaurantSpend, restaurantRewards);
        double monthlyGroceryRewards = calculateMonthlyRewards(grocerySpend, groceryRewards);
        double monthlyTravelRewards = calculateMonthlyRewards(travelSpend, travelRewards);
        double monthlyGasRewards = calculateMonthlyRewards(gasSpend, gasRewards);
        double monthlyOtherRewards = calculateMonthlyRewards(otherSpend, otherRewards);

        double totalMonthlyReward = monthlyRestaurantRewards + monthlyGroceryRewards + monthlyTravelRewards + monthlyGasRewards + monthlyOtherRewards;

        //calculate annual rewards
        double annualRestaurantReward = calculateAnnualRewards(monthlyRestaurantRewards);
        double annualGroceryReward = calculateAnnualRewards(monthlyGroceryRewards);
        double annualTravelReward = calculateAnnualRewards(monthlyTravelRewards);
        double annualGasReward = calculateAnnualRewards(monthlyGasRewards);
        double annualOtherReward = calculateAnnualRewards(monthlyOtherRewards);
        double totalAnnualRewards = annualRestaurantReward + annualGroceryReward + annualTravelReward + monthlyGasRewards + annualOtherReward;

        System.out.println("********MONTHLY REWARDS********\n");
        System.out.printf("Your monthly rewards for restaurants: $%.2f%n", monthlyRestaurantRewards);
        System.out.printf("Your monthly rewards for groceries: $%.2f%n", monthlyGroceryRewards);
        System.out.printf("Your monthly rewards for travel: $%.2f%n", monthlyTravelRewards);
        System.out.printf("Your monthly rewards for gas: $%.2f%n", monthlyGasRewards);
        System.out.printf("Your monthly rewards for other spending: $%.2f%n\n", monthlyOtherRewards);
        System.out.printf("Your monthly rewards for all spending: $%.2f%n\n", totalMonthlyReward);

        System.out.println("********ANNUAL REWARDS********\n");
        System.out.printf("Your annual rewards for restaurants: $%.2f%n", annualRestaurantReward);
        System.out.printf("Your annual rewards for groceries: $%.2f%n", annualGroceryReward);
        System.out.printf("Your annual rewards for travel: $%.2f%n", annualTravelReward);
        System.out.printf("Your annual rewards for gas: $%.2f%n", annualGasReward);
        System.out.printf("Your annual rewards for other spending: $%.2f%n\n", annualOtherReward);

        System.out.printf("""
                Your total annual rewards for the %s card: $%.2f%n
                """, cardName, totalAnnualRewards);
        System.out.println("********THE VERDICT**********\n");

        cardVerdict(annualFee, cardName, totalAnnualRewards);

        scanner.close();
    }

    public static double percentageConverter(double i) {
        return (i <= 0) ? i : i / 100;
    }

    public static double calculateMonthlyRewards(double spend, double rewardsPercentage) {
        return spend * rewardsPercentage;
    }

    public static double calculateAnnualRewards(double monthlyReward) {
        return monthlyReward * 12;
    }

    public static void cardVerdict (int annualFee, String cardName, double totalAnnualRewards){
        if (annualFee < totalAnnualRewards) {
            System.out.println("The " + cardName + " with an annual fee of $" + annualFee + " is worth it, given your spending");
        } else{
            System.out.println("The " + cardName + " with an annual fee of $" + annualFee + " is NOT worth it, given your spending");
        }
    }
}
