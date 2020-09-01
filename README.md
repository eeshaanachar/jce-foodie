# JCE Foodie
JCE Foodie is mobile app developed by foodies for foodies. We developed it as part of the Software Engineering Course, with emphasis on the various processes involved in the Software Development Life Cycle (SDLC). [See Requirements Engineering presentation](https://photos.google.com/share/AF1QipN4AAM6gAYSEezviM1WnM-q_gpLn14ZkR8lWUqBfI0tqlnvtChuAeC8fmXAvrZayg?key=UWc3RWJ3d0NZdDRTaWg2STZIMWxmMFhrUWVELVdn)

### Objective(s)
* Provide a POC to the advantages of using comparison based system over rating based system.
* User must be able to rank the food items from different restaurants.
* User must be able to view the rankings of restaurants in real time.
* Rankings must be separate for each food item.
* A Google maps link must be available to each of the restaurants.
* Admin must be able to add/update  items.

### Platform
* Android version: Android 4.3 Jellybean (API 18) or above
* Authentication and Cloud Storage: Firebase
* IDE: Android Studio
* Languages: Java, XML

### Working Principle
Admin uses the JCE Insider app (with credentials) to add food items to the database. Each item starts with 0 votes, which can increase or decrease based on users' ratings. You have to login to the main app i.e. JCE Foodie to be able to view and rank the restaurants. The dashboard shows the different food items available. Tapping any of these will take you to the rankings screen, where the rankings for different restaurants are shown for that food item. A Google maps link is also available to the right of each restaurant name, tapping on which will open the restaurant on maps. Tapping on the vote now option will take you to the voting screen where any 2 restaurants will be displayed against each other at random. You can either vote or skip to a different pair of restaurants. After voting, you will be taken back to the dashboard.

### Current Scope
* The admin app is very limited in functionality.
* There's no email confirmation required while signing up.
* People can vote multiple times.
* No exciting features to retain the users for long.