# Java Chess

A network-ready chess game in Java, playable entirely in the terminal—either versus another human (locally or over the network) or against a simple computer AI.

![Screenshot](https://github.com/matthewJamesAbbott/Java-Chess/raw/main/Java-Chess.png)

---

## Features

- **Terminal-based chess for two players or vs. computer**
- **Play in standalone, server, or client mode** across a network  
- **Handles move validation for regulation chess** (including special moves, depending on implementation)
- **Simple computer AI** (decision tree for move selection)
- **Easy-to-follow text interface**

---

## Getting Started

### Prerequisites

- Java 8+ (tested with OpenJDK and Oracle JDK)
- Command-line access

### Compilation

Clone the repo and compile all Java files:

```bash
git clone https://github.com/matthewJamesAbbott/Java-Chess.git
cd Java-Chess
javac *.java
```

### Running

**Standalone vs Human/Computer (no arguments):**
```bash
java xyz.squig.Main
```

**Server mode (wait for remote player):**
```bash
java xyz.squig.Main -s
```

**Client mode (connect to server's IP):**
```bash
java xyz.squig.Main -c [SERVER_IP_ADDRESS]
```

**Help:**
```bash
java xyz.squig.Main --help
```

---

## Controls

- Enter board coordinates as prompted (e.g., number for row, letter for column—`1 a 2 a` to move a piece from 1A to 2A; see CLI prompts).
- Type `9` where prompted to exit immediately.

---

## Project Structure

Core classes and their purposes:

- **`Main.java`** - Main entry point; handles user prompts and network game setup (client/server/standalone).
- **`Board.java`** - Board state and cell update/access methods.
- **`Engine.java`** - Contains AI logic for generating a move using a move tree.
- **`MoveCalculator.java`** - Evaluates board positions and determines legal moves for all pieces (including AI).
- **`Tree.java`** & **`TreeNode.java`** - Used by AI: builds a decision tree for move selection.
- **`LinkedList.java`** & **`Node.java`** - Stores and serializes lists of possible moves.

---

## Limitations & Notes

- Text-based UI only (no graphical/X support).
- Requires both client and server to have network connectivity (port 9008).
- AI is a basic material-capture search, not a strong chess engine.
- Games are not persisted—once stopped, progress is lost.

---

## License & Authorship

>This code is **not licensed for redistribution or commercial use**;  
>it is published here for learning and personal exploration.
>
>**Created by Matthew James Abbott**.  
>Do not reuse or redistribute without explicit permission.  
>Contact through GitHub for any permission requests.

---

**Enjoy Java Chess!**
