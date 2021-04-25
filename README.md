# LAB 4

University: Technical University of Moldova  
Specialty: Software Engineering  
Group: FAF-182
Object: Mobile Application Programming  
Teacher: Alexandr Vdovicenco  
Student: Vizant Beatrice  
## Technologies and language used:  
* Android   
* Kotlin   
* Retrofit  
* Dagger-Hilt  
* Databinding  

## Requirements  
* Perform a research on several mobile app architectures, they are almost the same for both platforms. Most popular architecture are MVC, MVP, MVVM, RIBs https://github.com/uber/RIBs , VIPER mostly for iOS, Hexagonal architecture https://en.wikipedia.org/wiki/Hexagonal_architecture_(software) 
* Pick up an architecture which fits the best your project and refactor your code base to selected architecture. Your codebase should be refactored to follow idiomatic representation of selected architecture. You should follow principles of "Clean Architectures" https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html and "Clean code" https://www.investigatii.md/uploads/resurse/Clean_Code.pdf and please refactor your code to look clean and structured. Messy projects will not be evaluated.
## Explanation:  
First thing was documenting about mobile applications architectures and thinking which one will fit best. After that I've tried to implement the MVP architecture which turned out to be a bit outdated in 2021 and not suitable some places for my application. So I switched to MVVM.  
MVVM - which separates view (Activities and Fragments) from business logic. MVVM is enough for small projects like mine. Advantages of such approach are: code is more easily testable, code is further decoupled, package structure is easier to navigate, project overall is easier to maintain. The view contains the visual part of the app binds to observable variables and actions exposed by the view model typically using the data binding framework. The view model contains the data required for the view. It is an abstraction of the view and exposes public properties and commands. It uses observable data to notify the view about changes. It also allows to pass events to the model. The model contains a data provider and the code to fetch and update the data.  
The way of how I applied this architecture inside my app is contained within each classes(for each line of code I've added comments so to be easier for anyone looking at the code to understand what is going on) So in the comments I've added the explanation of this laboratory for each separate class.  

## Status  
_IMPROVING THE CODE_
