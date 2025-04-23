# JumpBlox - 90s Arcade Platformer
Welcome to JumpBlox, a retro-inspired 2D platformer game built in Java with a 90s arcade aesthetic! Navigate through challenging levels, avoid obstacles, and aim for the highest score in this nostalgic gaming experience.
## 🎮 Overview
JumpBlox brings back the vibe of classic 90s arcade games with neon colors, pixelated graphics, and simple yet addictive gameplay. Features include:

### Two Levels: Jump across platforms and dodge spikes in two distinct levels.
High Score System: Track your best score based on distance traveled.
Retro Design: Neon pink, cyan, and green colors with a pixelated font (VT323) for that authentic arcade feel.
Main Menu: Start a new game, view high scores, or restart with ease.

## 📸 Screenshots
<p align="center">
  <img width="794" alt="image" src="https://github.com/user-attachments/assets/7aa3ffb2-3f0d-4a8c-9d2b-841fc396d98f" />
</p>

## 🛠️ Requirements
To run JumpBlox, you'll need:

Java Development Kit (JDK): Version 8 or higher.
Git: To clone the repository.
VT323 Font (Optional): For the retro font. Download it from Google Fonts and place it in the resources/ directory as VT323-Regular.ttf. If not included, the game falls back to a monospaced font.

## 🚀 Getting Started
### 1. Clone the Repository
```bash
git clone https://github.com/Innov8or123/JumpBlox.git
```

```bash
cd JumpBlox
```

### 2. Add the VT323 Font (Optional)

Download VT323-Regular.ttf from Google Fonts.
Create a resources/ directory in the project root.
Place the font file in resources/VT323-Regular.ttf.

### 3. Compile and Run the Game
Compile the Java file:
```bash
javac Platformer.java
```

### Run the game:
```bash
java Platformer
```


## 🎲 How to Play

Controls:
Left Arrow: Move left
Right Arrow: Move right
Up Arrow: Jump
1 or 2: Switch between Level 1 and Level 2
ESC: Return to the main menu


Objective: Navigate the platforms, avoid spikes, and travel as far as possible to increase your score.
Scoring: Your score increases based on the distance traveled (measured by your X position).
Game Over: Hitting a spike resets your position and updates the high score if applicable.

## 📂 Project Structure

Platformer.java: The main game file containing all logic, rendering, and UI.
resources/VT323-Regular.ttf: The optional retro font file for authentic 90s arcade styling.
screenshots/: Directory for game screenshots (add your own!).

## 🖥️ Gameplay Features

Main Menu: Start a new game, view the high score, or restart.
Levels: Two levels with different platform layouts and spike placements.
Retro Aesthetics: Neon colors, pixelated graphics, and a retro font.
Score Tracking: Displays current score, high score, and level during gameplay.

## 🤝 Contributing
Contributions are welcome! If you'd like to add features (e.g., sound effects, new levels, or improved graphics), follow these steps:

### Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Commit your changes (git commit -m "Add your feature").
Push to your branch (git push origin feature/your-feature).
Open a pull request.

## 📬 Contact
For questions or suggestions, reach out via GitHub Issues or contact the repository owner at Innov8or123.

