# Date Manager
(╯✧▽✧)╯

## Description
This is a Java-based date management system that handles date validation, calculations, and sorting. It supports both manual date entry and file input, while maintaining a history of all entered dates.
The program provides four main options:
1. **Manual date entry** – Users can input dates manually.
2. **Date history and sorting** – View and sort all previously entered dates.
3. **Date comparison** – Compare two dates and calculate the difference.

---

## Features
- Date validation with leap year support.
- Day of week calculation (e.g., "Monday").
- Date difference calculation.
- Chronological sorting.
- History tracking.

---

## How to Use

### Running the Date Manager
1. Compile the program:
   ```sh
   javac Date.java
   ```
2. Run the program:
   ```sh
   java Date
   ```
3. Choose an option from the menu:
   - `1` - Enter dates manually.
   - `2` - Compare two dates.
   - `3` - View and sort date history.
   - `4` - Exit.


### Example Usage
#### Manual Input
```
Welcome to Date Structure project! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧

Here are your options:
1) Enter dates manually.
2) View and sort date history.
3) Compare two dates.
4) Exit.

Choose an option: 1

Enter day (1-31): 16
Enter month (1-12): 12
Enter year: 2006

(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ 
Your date is December 16, 2006
Day of week: Saturday
Valid date!

Add another date? (y/n): n
Returning to menu... ( ° ∀ ° )ﾉﾞ
```

---
## Dependencies
- Java SE (JDK 8+)

---

## License
This project is open-source under the MIT License.

