# lAB 1

University: Technical University of Moldova  
Specialty: Software Engineering  
Group: FAF-182
Object: Mobile Application Programming
Teacher: Alexandr Vdovicenco

Laboratory work task:  

* Init mobile application on selected platform  
* Create at least 2 screens which transfer data from one screen to another  
* Perform some data changes to data you received in screen No.2 and pass  
it back to screen No. 1  
* Add at least one active element on the screen, ex. button, text field  
and handle its action. Some not trivial action handling are welcome  
* Change Icon of the app to custom one  

## Technologies and language used:
* Android   
* Kotlin   

## Explanation:  
In order to do this laboratory work, I chose to get the user a "lucky"  
number based on their birth date using Math.random where the date is  
passed. I also added logs to see the android activity lifecycle in practice
which was discussed during theory lessons. The output was in the Logcat  
window. Here is the result after running my application:  
![alt text](https://raw.githubusercontent.com/DivineBee/AndroidApp/Lab1/screens/Безымянный.png)  

Example of code to see the logs:  
```kotlin
    . . .
   override fun onStart() {
        Log.d(TAG, "onStart 2: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState 2: called")
        super.onRestoreInstanceState(savedInstanceState)
        secondDescr?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }
    . . .
```  

In the _screens_ folder I provided the screens on how application looks. 
Also changed the icon and also configured the constraints in that way that  
when a user will be rotating their phone, everything would stay in place.  

## Student:

| <a href="https://github.com/DivineBee" target="_blank">**Vizant Beatrice**</a>
| :---: |
| [![Vizant Beatrice](https://avatars0.githubusercontent.com/u/49019844?s=200&u=b232b6a4e7d387d304f0b7938eabe6cf742bacb8&v=4)](http://github.com/DivineBee)

## Status
_finished_