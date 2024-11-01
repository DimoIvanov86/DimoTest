Prerequisites:



Software Requirements

Java: Ensure JDK 11 or higher is installed. Set up JAVA_HOME environment variable.

Maven: Required for dependency management. Ensure Maven is installed and accessible in the system path.

Android SDK: For real device or emulator testing.

Appium: Install Appium Server (version 1.22 or higher recommended).

Android Device or Emulator: Set up a physical or virtual device for running the tests.

Device Setup:



Enable Developer Options on the Android device.

Enable USB Debugging on the device if using a real device.

Download app-debug.apk file from the recources folder and install it on the phone.

Android App:
The Android app supports Android 12 and above, The app is using mocked data, so only the following email and password will go through the flow:

Email: test@example.com

Password: password123

All other emails and password will be treated as a wrong email or password.
