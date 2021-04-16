# Conduit
Blogging application for Android using Open Source Conduit Api

> ### Android/Kotlin codebase containing real world examples (CRUD, auth, advanced patterns, etc) that adheres to the [RealWorld](https://github.com/gothinkster/realworld) spec and API.


### Concepts
This RealWorld app tries to show the following Android concepts:
* 100% Kotlin Codebase
* MVVM (Model View ViewModel) Architecture
* LiveData
* Kotlin Coroutines
* Jetpack Navigation Architecture

### Architecture
The project follows the general MVVM structure.

There are two _modules_ in the project 

* `app` - The UI of the app. The main project that forms the APK
* `api` - The REST API consumption library. Pure JVM library not Android-specific
