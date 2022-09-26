import java.util.Random;

public class BendingBattlefield {
    public static void main(String[] args) {
        Random rand = new Random();
        int numHeroes = rand.nextInt(51) + 50;
        double boomerangBoost = rand.nextDouble() * 4.0 + 3.0;
        double averageFirePower = 0.0;
        double averageFireHealth = 0.0;
        double averageAlliancePower = 0.0;
        double averageAllianceHealth = 0.0;

        System.out.printf("Selecting %s heroes.%n", numHeroes);

        int numFire = 0;
        int numAlliance = 0;

        // Loop terminates after numHeroes iterations
        //
        for (int i = 0; i < numHeroes; i++) {
            //System.out.println(i);
            BendingType heroType = BendingType.values()[rand.nextInt(5)];
            double health = rand.nextDouble() * 100.0 + 50.0;
            health = (Math.round(health * 100.0) / 100.0);
            double power = (-rand.nextDouble() * 80) + 120.0;
            power = (Math.round(power * 100.0) / 100.0);
            switch (heroType) {
            case FIRE:
                averageFireHealth += health;
                averageFirePower += power;
                numFire++;
                break;
            default:
                averageAllianceHealth += health;
                averageAlliancePower += power;
                numAlliance++;
            }
            System.out.printf("%s hero has been summoned by his army"
                + ", adding %6.2f power and %6.2f health to the army. %n", heroType, power, health);
        }
        averageFirePower /= numFire;
        averageFireHealth /= numFire;
        averageFirePower = (Math.round(averageFirePower * 100.0) / 100.0);
        averageFireHealth = (Math.round(averageFireHealth * 100.0) / 100.0);

        averageAlliancePower /= numAlliance;
        averageAllianceHealth /= numAlliance;
        averageAlliancePower = (Math.round(averageAlliancePower * 100.0) / 100.0);
        averageAllianceHealth = (Math.round(averageAllianceHealth * 100.0) / 100.0);

        System.out.printf("The Fire Nation has an average of %.2f power"
            + " and %.2f health.%n", averageFirePower, averageFireHealth);
        System.out.printf("The Alliance Nation has an average of %.2f power"
            + " and %.2f health.%n", averageAlliancePower, averageAllianceHealth);

        double fireStrength = 2 * averageFirePower + 3 * averageFireHealth;
        double allianceStrength = 2 * averageAlliancePower + 3 * averageAllianceHealth;
        if (allianceStrength < fireStrength) {
            System.out.println("The Fire Nation won!");
        } else {
            System.out.println("The Alliance won!");
        }
    }
}
