package machine;

import java.util.Scanner;

public class CoffeeMachine {

	static int WATER_MACHINE = 400;
	static int MILK_MACHINE = 540;
	static int COFFEE_MACHINE = 120;
	static int CUPS_MACHINE = 9;
	static int MONEY_MACHINE = 550;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String command = sc.next();
        while (!command.equals("exit")) {
        	switch (command) {
    		case "take":
    			take();
    			break;
    		case "buy":
    			buy();
    			break;
    		case "fill":
    			fill();
    			break;
    		case "remaining":
    			printParams();
    			break;
    		default:
    			System.out.println("Unknown command!");
    			break;
    		}
        	System.out.println("Write action (buy, fill, take, remaining, exit):");
        	command = sc.next();
		}
        sc.close();
    }

    private static void printParams() {
		System.out.println("The coffee machine has:");
		System.out.println(WATER_MACHINE + " of water");
		System.out.println(MILK_MACHINE + " of milk");
		System.out.println(COFFEE_MACHINE + " of coffee beans");
		System.out.println(CUPS_MACHINE + " of disposable cups");
		System.out.println(MONEY_MACHINE + " of money");
	}
	
	private static void fill() {
		System.out.println("Write how many ml of water do you want to add:");
		WATER_MACHINE += sc.nextInt();
		System.out.println("Write how many ml of milk do you want to add:");
		MILK_MACHINE += sc.nextInt();
		System.out.println("Write how many grams of coffee beans do you want to add");
		COFFEE_MACHINE += sc.nextInt();
		System.out.println("Write how many disposable cups of coffee do you want to add:");
		CUPS_MACHINE += sc.nextInt();
	}
	
	private static void buy() {
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
		switch (sc.next()) {
		case "1":
			checkDrink(Coffee.valueOf("ESPRESSO"));
			break;
		case "2":
			checkDrink(Coffee.valueOf("Latte"));
			break;
		case "3":
			checkDrink(Coffee.valueOf("Cappuccino"));
			break;
		case "back":
			break;
		default:
			System.out.println("Unknown drink!");
			break;
		}
	}
	
	private static void checkDrink(Coffee coffee) {
		if (WATER_MACHINE >= coffee.water && MILK_MACHINE >= coffee.milk && COFFEE_MACHINE >= coffee.coffee && CUPS_MACHINE >= 0) {
			System.out.println("I have enough resources, making you a coffee!");
			WATER_MACHINE -= coffee.water;
			MILK_MACHINE -= coffee.milk;
			COFFEE_MACHINE -= coffee.coffee;
			MONEY_MACHINE += coffee.money;
			CUPS_MACHINE--;
		} else if (WATER_MACHINE < coffee.water) {
			System.out.println("Sorry, not enough water!");
		} else if (MILK_MACHINE < coffee.milk) {
			System.out.println("Sorry, not enough milk!");
		} else if (COFFEE_MACHINE < coffee.coffee) {
			System.out.println("Sorry, not enough coffee!");
		} else {
			System.out.println("Sorry, not enough cups!");
		}
	}
	
	private static void take() {
    	System.out.println("I gave you $" + MONEY_MACHINE);
    	MONEY_MACHINE = 0;
    }
	
}