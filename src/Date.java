// Connecting libraries
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Date implements Comparable<Date> {
    // ArrayList for storing date history
    private static final ArrayList<String> dateHistory = new ArrayList<>();

    // Constants for month and day names
    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private static final String[] DAY_NAMES = {
            "Saturday", "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday"
    };

    // Date components
    private int day;
    private int month;
    private int year;

    // Main constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        if (!isValidDate()) {
            System.out.println("Error: Date might be invalid! (シ_ _)シ");
        }
    }

    // Method to validate date
    private boolean isValidDate() {
        // First check year
        if (year < 1) {
            return false;
        }

        // Then check month
        if (month < 1 || month > 12) {
            return false;
        }

        // Finally check day based on month
        int maxDays;
        switch (month) {
            case 4: case 6: case 9: case 11:
                maxDays = 30;
                break;
            case 2:
                maxDays = isLeapYear() ? 29 : 28;
                break;
            default:
                maxDays = 31;
        }

        return day >= 1 && day <= maxDays;
    }

    // Helper method for leap year check
    private boolean isLeapYear() {
        if (year % 4 != 0) {
            return false;
        }
        else if (year % 100 != 0) {
            return true;
        }
        else {
            return year % 400 == 0;
        }
    }

    // Method to update date with validation
    public void updateDate(int newDay, int newMonth, int newYear) {
        int oldDay = this.day;
        int oldMonth = this.month;
        int oldYear = this.year;

        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;

        if (!isValidDate()) {
            this.day = oldDay;
            this.month = oldMonth;
            this.year = oldYear;

            System.out.println("Update failed! Invalid date! (╯°□°)╯︵ ┻━┻");
        }
    }

    // Method to get day of week
    public String getDayOfWeek() {
        int m = month;
        int y = year;

        // Zeller's Congruence adjustment
        if (m < 3) {
            m += 12;
            y--;
        }

        int century = y / 100;
        int yearInCentury = y % 100;

        int dayOfWeek = (day + 13*(m + 1) / 5 + yearInCentury +
                yearInCentury / 4 + century / 4 + 5 * century) % 7;

        return DAY_NAMES[dayOfWeek];
    }

    // Method to calculate difference between dates
    public int calculateDifference(Date otherDate) {
        // Simple calculation assuming 30 days per month
        int thisTotal = this.year * 360 + this.month * 30 + this.day;
        int otherTotal = otherDate.year * 360 + otherDate.month * 30 + otherDate.day;

        return Math.abs(thisTotal - otherTotal);
    }

    // Method to print date in expected format
    public void printDate() {
        System.out.println(MONTH_NAMES[month-1] + " " + day + ", " + year);
    }

    // Required method for Comparable interface
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        else {
            return Integer.compare(this.day, other.day);
        }
    }

    // Method for manual date input
    public static void enterDateManually() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter day (1-31): ");
            int day = input.nextInt();

            System.out.print("Enter month (1-12): ");
            int month = input.nextInt();

            System.out.print("Enter year: ");
            int year = input.nextInt();

            input.nextLine(); // Clear buffer

            Date userDate = new Date(day, month, year);
            System.out.print("\n(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ \nYour date is ");

            if (userDate.isValidDate()) {
                userDate.printDate();
                System.out.println("Day of week: " + userDate.getDayOfWeek());
                System.out.println("Valid date!");

                dateHistory.add(userDate + " (" + userDate.getDayOfWeek() + ")");
            }
            else {
                System.out.println("Invalid date! (シ_ _)シ");
            }

            System.out.print("\nAdd another date? (y/n): ");
            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase("n")) {
                System.out.println("Returning to menu... ( ° ∀ ° )ﾉﾞ");
                break;
            }
        }
    }

    // Method to display and sort date history
    private static void showAndSortDates() {
        if (dateHistory.isEmpty()) {
            System.out.println("\nNo dates in history yet! (＃￣0￣)");
            return;
        }

        System.out.println("\nYour date history:");
        for (int i = 0; i < dateHistory.size(); i++) {
            System.out.println((i + 1) + ") " + dateHistory.get(i));
        }

        System.out.println("\n(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ Dates sorted chronologically:");
        ArrayList<Date> dates = new ArrayList<>();

        for (String entry : dateHistory) {
            String[] parts = entry.split(" ")[0].split("/");
            dates.add(new Date(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2])
            ));
        }

        Collections.sort(dates);

        for (Date d : dates) {
            System.out.println(d);
        }
    }

    // Method to compare two dates
    private static void compareDates() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter first date:");
        System.out.print("Day (1-31): ");
        int day1 = input.nextInt();

        System.out.print("Month (1-12): ");
        int month1 = input.nextInt();

        System.out.print("Year: ");
        int year1 = input.nextInt();

        System.out.println("\nEnter second date:");
        System.out.print("Day (1-31): ");
        int day2 = input.nextInt();

        System.out.print("Month (1-12): ");
        int month2 = input.nextInt();

        System.out.print("Year: ");
        int year2 = input.nextInt();
        input.nextLine(); // Clear buffer

        Date date1 = new Date(day1, month1, year1);
        Date date2 = new Date(day2, month2, year2);

        System.out.println("\nヽ(>∀<☆)ノ\nComparison results:");
        if (date1.isValidDate() && date2.isValidDate()) {
            System.out.println("Difference: ~" + date1.calculateDifference(date2) + " days");

            System.out.println("Day of week for the first date: " + date1.getDayOfWeek());
            System.out.println("Day of week for the second date: " + date2.getDayOfWeek());

            dateHistory.add(date1.toString());
            dateHistory.add(date2.toString());
        }
        else {
            System.out.println("Cannot compare invalid dates! (シ_ _)シ");
        }
    }

    // Main method with menu
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nWelcome to Date Structure project! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");

        while (true) {
            System.out.println("\nHere are your options:");
            System.out.println("1) Enter dates manually.");
            System.out.println("2) View and sort date history.");
            System.out.println("3) Compare two dates.");
            System.out.println("4) Exit.");

            System.out.print("\nChoose an option: ");

            if (input.hasNextInt()) {
                int option = input.nextInt();
                input.nextLine(); // Clear buffer

                switch (option) {
                    case 1:
                        enterDateManually();
                        break;
                    case 2:
                        showAndSortDates();
                        break;
                    case 3:
                        compareDates();
                        break;
                    case 4:
                        System.out.println("\nGoodbye! ( ° ∀ ° )ﾉﾞ");
                        return;
                    default:
                        System.out.println("Invalid option! ＼(º □ º l|l)/");
                }
            }
            else {
                System.out.println("Please enter a number! (シ_ _)シ");
                input.nextLine(); // Clear buffer
            }
        }
    }
}