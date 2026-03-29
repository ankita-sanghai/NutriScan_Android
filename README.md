# NutriScan 🥗

A modern Android food & nutrition tracker built with **Jetpack Compose**, **Clean Architecture**, and **Material 3**.

## Screenshots
_Coming soon — app launches in Week 4_

## Architecture

```
NutriScan/
├── app/                        # App module — DI, navigation, MainActivity
├── core/
│   ├── common/                 # Shared utilities, extensions
│   ├── design/                 # Theme, colors, typography
│   ├── database/               # Room DB — entities, DAOs
│   └── network/                # Retrofit — OpenFoodFacts API
└── feature/
    ├── home/                   # Daily calorie ring + macro summary
    ├── search/                 # Food search with debounce + offline cache
    ├── diary/                  # Meal log history + weekly trends
    ├── scanner/                # CameraX + ML Kit barcode scanner
    └── profile/                # User goals + settings
```

## Tech Stack

| Layer | Technology |
|---|---|
| UI | Jetpack Compose, Material 3 |
| Architecture | MVVM + Clean Architecture, multi-module |
| DI | Hilt |
| Database | Room |
| Networking | Retrofit + Moshi + OkHttp |
| Async | Kotlin Coroutines + Flow |
| Image loading | Coil |
| Charts | Vico |
| Camera | CameraX + ML Kit |
| Navigation | Navigation Compose |

## API

Uses the free [Open Food Facts API](https://world.openfoodfacts.org/) — no API key required, 900K+ food items.

## Build & Run

1. Clone the repo
2. Open in Android Studio Meerkat or later
3. Run on device or emulator (API 26+)

## Status

- [x] Project setup — Clean Architecture modules
- [x] Theme + design system
- [x] Room database — FoodLog, FoodCache entities
- [x] Retrofit — OpenFoodFacts API client
- [x] Home screen — calorie ring + macro cards
- [ ] Food search with debounce
- [ ] Barcode scanner (CameraX + ML Kit)
- [ ] Diary screen + charts
- [ ] Play Store release

## Author

**Ankita Sanghai** — Android Developer  
[LinkedIn](https://linkedin.com/in/ankita-sanghai-a45635167) · [GitHub](https://github.com/ankita-sanghai)
