# Mana Grimoire

**Mana Grimoire** is a mobile application for **Magic: The Gathering** players designed to help manage card collections, build decks, and enhance gameplay in a structured, modern, and offline-first way.

The app allows users to:
- Register and organize their MTG card collection  
- Build and manage decks (starting with Commander, with support for other formats planned)  
- Search cards using the Scryfall API  
- Track printings, editions, and prices  
- Scan cards for quick collection input (planned)  
- Track life totals during matches (planned)  
- Connect with other players to **trade cards based on their collections and needs**  
- Synchronize data across devices using cloud services  

Mana Grimoire is built with **Flutter**, following an **offline-first architecture** with local persistence and cloud synchronization.

---

## Features (Initial Scope)

- 📚 Card search and metadata powered by Scryfall  
- 🧙 Deck building with support for Commander and future formats  
- 📦 Collection tracking by card printing  
- 🔍 Card scanning for fast collection management (planned)  
- ❤️ Life tracker for in-game use (planned)  
- 🤝 Player-to-player trading system based on collections and deck needs (planned)  
- 💾 Local persistence using SQLite (Drift)  
- ☁️ Cloud synchronization via Firebase (Auth + Firestore)  
- 💰 Price tracking (initially via Scryfall, extensible to other sources)  

---

## Tech Stack

- **Flutter** (Mobile: Android / iOS)  
- **SQLite (Drift)** for local storage  
- **Firebase Authentication & Firestore** for sync and user data  
- **Scryfall API** for card data and pricing  

---

## Project Status

🚧 **Early development / MVP phase**

The project is under active development. Architecture and data models are being defined with scalability and future features in mind.

---

## Roadmap (High-Level)

- [ ] Core data models and local database  
- [ ] Card search and caching (Scryfall)  
- [ ] Deck management (Commander MVP)  
- [ ] Collection management  
- [ ] Deck import/export  
- [ ] Card scanning  
- [ ] Life tracker  
- [ ] Trading system (match players based on card needs and availability)  
- [ ] Cloud sync  
- [ ] Price providers (BR sources planned)  

---

## Disclaimer

Mana Grimoire is an **unofficial** fan-made application.  
Magic: The Gathering and related properties are trademarks of Wizards of the Coast.  
This project is not affiliated with or endorsed by Wizards of the Coast.