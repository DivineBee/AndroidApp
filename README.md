# LAB 2

University: Technical University of Moldova  
Specialty: Software Engineering  
Group: FAF-182
Object: Mobile Application Programming  
Teacher: Alexandr Vdovicenco  

## Technologies and language used:
* Android   
* Kotlin   

## Explanation:  
A theme should be picked so I decided to make a money manager app which will analyse the expenses and will say how many % of the monthly amount I should save for different things including the "safe pillow".  
After deciding the theme I implemented a new verison of main menu screen, which for now will contain only 3 buttons:  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Laboratory2/app/src/main/gitscreens/photo_2021-02-21_18-59-59.jpg?raw=true)  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Laboratory2/app/src/main/gitscreens/photo_2021-02-21_18-59-59%20(6).jpg?raw=true)  

Then I had to implement a RecyclerView where user's expenses will go. I created a layout, and the SecondActivity from previous lab now is responsible for the recycler view handling which supports vertical scrolling. Also created an Adapter Adapter to handle the data collection and bind it to the view. And used the Data Binding library it's main task is to transfer the interaction between the model and the View into xml files. It greatly simplifies writing code and eliminates the need to use findByViewId () methods, add links to view-elements inside Activities or Fragments. The working recycler view with some random data similar to real ones looks like this:  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Laboratory2/app/src/main/gitscreens/photo_2021-02-21_18-59-59%20(2).jpg?raw=true)  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Laboratory2/app/src/main/gitscreens/photo_2021-02-21_18-59-59%20(5).jpg?raw=true)  

Also any activity in the application is supporting rotation of landscape mode and also because I didn't made constraints fixed, the application is supporting any screen size. Next I had to create a 3rd screen, I thought it will be nice to make a details page for every expense item(which in future may be a screen for editing the expenses added). So its an activity which will output more information about the items in the RecyclerView, in future the details might be such as date and time and some notes or edit information. To pass the data from recycler view to details activity I used my knowledge from the first lab where intents were used, and applied to the second lab. The details activity looks like this:  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Laboratory2/app/src/main/gitscreens/photo_2021-02-21_18-59-59%20(3).jpg?raw=true)  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Laboratory2/app/src/main/gitscreens/photo_2021-02-21_18-59-59%20(4).jpg?raw=true)  

## Status
_finished_
