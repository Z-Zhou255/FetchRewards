# FetchRewards Coding Exercise - Software Engineering - Mobile

## Description

This project is a native Android application built in Kotlin that retrieves data from the provided URL: [https://fetch-hiring.s3.amazonaws.com/hiring.json](https://fetch-hiring.s3.amazonaws.com/hiring.json), processes it, and displays the results to the user in an intuitive and user-friendly format. The app is designed to meet the specific requirements of the Fetch Rewards coding exercise.

### Features

- Fetches and processes data from the provided JSON endpoint.
- Displays items grouped by `listId` with results sorted by `listId` and `name`.
- Filters out items where the `name` is blank or null to ensure only valid data is shown.
- Presents the results in an easy-to-read list, leveraging modern Android UI principles.

## Requirements

- Android Studio with the latest stable version.
- Kotlin (latest stable version).
- Minimum supported Android version: [specify the version you support, e.g., Android 5.0 Lollipop (API 21)].

## Libraries and Tools

To ensure a high-quality, scalable, and efficient app, the project leverages a range of modern Android libraries and tools, including:

### UI Development

The app uses Jetpack Compose, Android's modern toolkit for building UIs. This approach simplifies UI development with a declarative syntax, allowing for dynamic, responsive layouts with minimal code. Compose integrates seamlessly with the Android lifecycle, offering enhanced performance and ease of testing. Material Design 3 components are also incorporated to ensure the app follows modern design guidelines, providing a consistent and accessible user experience.

### Networking and Data Handling

For network communication, the app utilizes a robust HTTP client that handles data fetching from the provided API endpoint. The data is parsed into Kotlin data classes using a popular JSON converter, ensuring type safety and simplicity in handling API responses. Additionally, logging and network monitoring are implemented to provide transparency and facilitate debugging during development.

### Lifecycle and State Management

The app employs the Android lifecycle-aware components to efficiently manage UI-related data. ViewModel and LiveData are used to store and manage data in a lifecycle-conscious manner, ensuring that the app remains responsive and that data survives configuration changes.

### Performance Enhancements

To improve the user experience, the app includes a loading shimmer effect, which gives users a visual indication that data is being loaded. This enhances the perceived performance and provides a smooth transition as content is fetched and displayed.

### Testing and Quality Assurance

Unit and UI tests are a critical part of ensuring the app works as expected. The project leverages powerful testing frameworks and tools to write comprehensive tests for both the logic and UI components. This includes unit tests to verify business logic, as well as UI tests to ensure the app behaves correctly across different scenarios. Mocking libraries are used to simulate various conditions and ensure robust, reliable tests.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/jonhazut9/fetch-rewards.git
