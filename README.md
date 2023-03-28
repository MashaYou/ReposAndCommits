
# X Company test assignment: ReposAndCommits  
The aim of this test assignment is to build an App that connects to the Github API, shows the public repositories of a particular user and then retrieves their respective last commits.  
  
## Prerequisites  
Please create an Android Studio / Gradle Project, upon completion of the task upload it to any file sharing resource of your choice (ex. Google Drive, Dropbox etc.) and share the link with us in a response email. The Project needs to compile and be executable on a state of the art Android Phone. Use SDK Level 21 and above.  
Try to keep the project as vanilla and as possible. However, the following 3rd party libraries are allowed:  
Retrofit / Volley, RxJava / Coroutines, Dagger 2 / Hilt. We do not accept solutions executed with Jetpack Compose.  
Please do not spend more than ca. 6 hours on the assignment. Incomplete solutions are also acceptable - the task is designed that way.  
Please add a readme with the assignment to explain your development approach and/or things that you would do differently.  
  
## Task 1 - Connect to the Github API  
Connect to the Github API to retrieve the list of public repositories in your Github Account. Alternatively, use this account: https://api.github.com/users/mralexgray/repos  
This results in a list of public Repositories. Visualize the results in a list. You are free to choose any meaningful subset of data to show in each row.  
  
## Task 2 - Create a detail page for the repository  
Upon clicking an item on the repository list, redirect the user to a detail page.  
Retrieve information about all the commits in the selected repository. Then render any relevant data into a simple detail page. This can be done with the following call:  
https://api.github.com/repos/mralexgray/ACEView/commits  
Where “mralexgray” (see Task 1) is the user and “ACEView” the repository under consideration. Again, feel free to choose any meaningful subset of data to display.  
  
## Task 3 - Create a custom view to display commits in a month  
  
On the detail page, a custom view with the following requirements should be shown.  
-   At the base of the view should be a text denoting the month.  
-   It should contain a rectangle, akin to the bar in a bar chart. The height of the bar should be in  
    proportion to the number of commits in the given month vs the maximum commits in a month  
    for that repository.  
-   Another text, aligned with the top of the bar should show the number of commits in that month.  
    It should look similar to this. Feel free to choose your own color scheme and make your own design choices.  

<img width="346" alt="Bildschirm­foto 2023-01-19 um 18 12 41" src="https://user-images.githubusercontent.com/120378890/213479404-8287d235-1c00-48f0-aea8-c8bdacd74e55.png">

## Task 4 - Cycle through all the months and trigger updates on the custom view.
While the user is on the detail page, the custom view needs to update continuously and should be cycling through all the months.
Create a mechanism that can update the custom view at an interval of 1.5 seconds.
At each new interval, the height of the bar, the month name text and the number of commits text should be updated.
The user should be free to navigate back to the repository list and open up a different repository’s detail page.

**Bonus - Animate the height changes in the bar with each new update.**


# Result
<video src="https://user-images.githubusercontent.com/120378890/213663108-dd3725d6-2ee8-4e46-890d-fc4fd7fd2c9f.mp4"></video>

## Tech stack:
- Kotlin
- ViewModel
- LiveData
- ConstraintLayout
- NavigationComponent
- RxJava2
- Hilt
- Room
- Retrofit
- Glide
- Junit Jupiter 5
