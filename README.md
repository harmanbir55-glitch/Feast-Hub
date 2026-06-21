# Feast-Hub
My first and most favourite project i ever made.....i was in first semester when i made the web version(HTML) for it, im so glad that i finished it and it looks amazing with all the things working as i want.

Feast-Hub is a professional Java-based recipe management and pantry support application. It allows users to create recipes, rate recipes, manage pantry ingredients, and generate system-style reports and troubleshooting logs.

This project is designed to show my software development and computer technician skills, including Java programming, file handling, user support workflows, system logging, backup/recovery, organized documentation, and attention to detail.

## Features

- Create, view, search, and rate recipes
- Manage pantry ingredients with quantity and expiry tracking
- Match available pantry items with recipes
- Generate recipe and pantry performance reports
- Maintain a problems-and-solutions support log
- Perform local data backup and recovery operations
- Simple menu-based Java console interface
- Clean object-oriented structure using models, services, and utilities

## Technologies Used

- Java
- Object-Oriented Programming
- File I/O
- CSV-style local storage
- Git and GitHub
- Command-line application design

## Project Structure

```text
Feast-Hub/
├── README.md
├── .gitignore
├── data/
│   ├── recipes.csv
│   ├── pantry.csv
│   └── support-log.csv
├── docs/
│   ├── USER_GUIDE.md
│   ├── TECHNICAL_DOCUMENTATION.md
│   └── TROUBLESHOOTING_LOG.md
├── scripts/
│   └── run.sh
└── src/main/java/com/feasthub/
    ├── app/
    │   └── FeastHubApp.java
    ├── model/
    │   ├── Ingredient.java
    │   ├── Recipe.java
    │   └── User.java
    ├── service/
    │   ├── BackupService.java
    │   ├── PantryService.java
    │   ├── RecipeService.java
    │   └── SupportLogService.java
    └── util/
        ├── CsvUtil.java
        └── InputValidator.java
```

## How to Run

From the project root:

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.feasthub.app.FeastHubApp
```

Or use:

```bash
chmod +x scripts/run.sh
./scripts/run.sh
```

## Sample Login Roles

This console version includes basic role examples in code:

- Admin: can view reports, backup data, and manage support logs
- User: can create recipes, rate recipes, and manage pantry items

## Web Demo

This repository also includes a lightweight web demo for portfolio presentation.

To open it locally:

1. Open the `web` folder.
2. Double-click `index.html`, or right-click and choose **Open With → Browser**.

Web demo files:

- `web/index.html`
- `web/style.css`
- `web/script.js`
