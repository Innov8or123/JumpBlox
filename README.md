# JumpBlox - 90s Arcade Platformer

JumpBlox is a 2D platformer game inspired by 90s arcade games, built in Java. Navigate through levels, avoid obstacles, and aim for the highest score.

## Features
- **Two Levels**: Each with unique platform layouts and spike placements.
- **High Score Tracking**: Based on distance traveled.
- **Retro Design**: Neon color scheme and pixelated font (VT323).
- **Main Menu**: Start, view high scores, or restart the game.

## Screenshots
<p align="center">
  <img width="794" alt="image" src="https://github.com/user-attachments/assets/7aa3ffb2-3f0d-4a8c-9d2b-841fc396d98f" />
</p>

## Requirements
- **JDK 8+**
- **Git**
- **VT323 Font** (Optional): Download from [Google Fonts](https://fonts.google.com/specimen/VT323) and place in `resources/VT323-Regular.ttf`.

## Getting Started

1. **Clone the Repository**
    ```bash
    git clone https://github.com/Innov8or123/JumpBlox.git
    cd JumpBlox
    ```

2. **Add Font (Optional)**  
   - Download `VT323-Regular.ttf` and place it in `resources/VT323-Regular.ttf`.

3. **Compile and Run**
    ```bash
    javac Platformer.java
    java Platformer
    ```

## Controls
- **Left Arrow**: Move left
- **Right Arrow**: Move right
- **Up Arrow**: Jump
- **1/2**: Switch between Level 1 and Level 2
- **ESC**: Main menu

## Scoring
Your score increases based on the distance traveled. The game resets on hitting a spike, and the high score is updated if applicable.

## Project Structure
- `Platformer.java`: Main game logic, rendering, and UI.
- `resources/VT323-Regular.ttf`: Retro font (optional).
- `screenshots/`: Directory for game screenshots.

## Contributing
1. Fork the repository.
2. Create a new branch.
3. Commit changes.
4. Open a pull request.

## Contact
For inquiries, open an issue or contact the repository owner at Innov8or123.

