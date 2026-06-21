# Technical Documentation

## Application Type
Java console application using local CSV data storage.

## Architecture

The application uses a clean object-oriented structure:

- `model`: data classes such as Recipe, Ingredient, and User
- `service`: business logic for recipes, pantry, support logs, and backups
- `util`: reusable helper classes for CSV handling and validation
- `app`: main application entry point

## Data Files

- `data/recipes.csv`: stores recipe records
- `data/pantry.csv`: stores pantry ingredient records
- `data/support-log.csv`: stores user issues and solutions

## Technical Support Alignment

This project simulates business-system support tasks:

- System reporting through menu option 12
- Backup operations through menu option 10
- Recovery guidance through menu option 11
- Problems and solutions logging through options 8 and 9
- User training through the included user guide

## Installation

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.feasthub.app.FeastHubApp
```

## Maintenance Notes

- Keep data files inside the `data` folder.
- Run backup before making major data changes.
- Check support logs regularly to identify repeated user issues.
