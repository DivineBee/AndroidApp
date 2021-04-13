# LAB 3

University: Technical University of Moldova  
Specialty: Software Engineering  
Group: FAF-182
Object: Mobile Application Programming  
Teacher: Alexandr Vdovicenco  

## Technologies and language used:
* Android   
* Kotlin   

## Requirements
* Pick an API it could be public or private in case you have access to it. You could use your own API or TCP server (in case you a building chat). In case if you use Firebase or another serverless service, please add integration to Firebase but also implement connection to another API by performing standard HTTP requests.
* Implement at least 2 GET and 2 POST requests. At least 1 of your request should send data to API by request body in JSON format, but not by URL queries.
* On Android you have to use Retrofit(https://square.github.io/retrofit/) and kotlin coroutines on iOS you have to use Alamofire(https://github.com/Alamofire/Alamofire) and RxSwift(https://github.com/ReactiveX/RxSwift) 
* Add 2 more screens with implemented design, your app should have at least 5 screen, not just layout, but with implemented design.
* Add basic navigation component for in app navigation drawer menu(swipeable menu from left to right), or tab bar navigation(bottom bar with tabs) 

## Explanation:  
For this laboratory I decided to make a money converter which was the most optimal solution on where I can make use of an API for the theme picked for my application. The chosen API was: http://api.exchangeratesapi.io/v1/. When I made this lab this api was free to use but now they added paid version and it gave me some trouble because of that. To use the API correctly I had to use retrofit and coroutines inside my android application. Retrofit is a simple network library that can be used for network transactions. By using this library we can capture JSON response from web service/web API. It’s easy and fast library to retrieve and upload the data(JSON or any other structured data) via a REST based web service. But Coroutines are nothing but light-weight threads. Coroutines provide an easy way to do synchronous and asynchronous programming. I also made use of suspend function, suspend — is an indication saying that the method associated with this modifier is synchronous and will not be returned immediately. The method associated with it will be suspended for a while and then return the result when available. Knowing this I was able to use it in my request.

Because I want to make a "sellable" application and it needs to be UX and UI appropriate, I decided not to over-engineer and overflow my application with unenecessary features and apis such as meteo or social apis in order to conform to the requirement to have multiple post and get request. Because it:  
1. Will make the application less performant.   
2. As we know not everyone has lots of gigabytes of internet on the phone and use of lots of apis will use plenty(the user will not be happy about that)
3. The application has a strict theme of money management so there is no point of adding unnecessary features or ambiguous, unrelated requests. 

I decided to use 1 get request but to work on it and make it appropriate in terms of UI and UX. So through an api I'm getting the rates and then do some maths in background in order to make the conversion from a currency to another. And this is how it looks:  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Lab3/screens/converter.jpg?raw=true)  
The user is able to pick through a spinner the currency from which he wants to convert to another spinner with another currency that he/she needs. Also in this lab I decided to add Dagger Hilt. Hilt works by code generating your Dagger setup code for you. This takes away most of the boilerplate of using Dagger and really just leaves the aspects of defining how to create objects and where to inject them. Hilt will generate the Dagger components and the code to automatically inject your Android classes (like activities and fragments) for you. I used it mainly for coroutines. Example use of it in my code:  
```kotlin
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCurrencyApi(): CurrencyApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CurrencyApi::class.java)

    @Singleton
    @Provides
    fun provideMainRepostiory(api: CurrencyApi): MainRepository = DefaultMainRepository(api)

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}
```
The _DispatcherProvider_ used above is an interface:
```kotlin
interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
```
Next in the _MainViewModel_ all the magic is happening regarding using coroutines and appropriate event handling.
```kotlin
class MainViewModel @ViewModelInject constructor(
        private val repository: MainRepository,
        private val dispatchers: DispatcherProvider
) : ViewModel() {

    sealed class CurrencyEvent {
        class Success(val resultText: String) : CurrencyEvent()
        class Failure(val errorText: String) : CurrencyEvent()
        object Loading : CurrencyEvent()
        object Empty : CurrencyEvent()
    }

    private val _conversion = MutableStateFlow<CurrencyEvent>(CurrencyEvent.Empty)
    val conversion: StateFlow<CurrencyEvent> = _conversion

    fun convert(
            amountStr: String,
            fromCurrency: String,
            toCurrency: String
    ) {
        val fromAmount = amountStr.toFloatOrNull()
        if (fromAmount == null) {
            _conversion.value = CurrencyEvent.Failure("Not a valid amount")
            return
        }

        viewModelScope.launch(dispatchers.io) {
            _conversion.value = CurrencyEvent.Loading
            when (val ratesResponse = repository.getRates(fromCurrency)) {
                is Resource.Error -> _conversion.value =
                        CurrencyEvent.Failure(ratesResponse.message!!)
                is Resource.Success -> {
                    val rates = ratesResponse.data!!.rates
                    val rate = getRateForCurrency(toCurrency, rates)
                    if (rate == null) {
                        _conversion.value = CurrencyEvent.Failure("Unexpected error")
                    } else {
                        val convertedCurrency = round(fromAmount * rate * 100) / 100
                        _conversion.value = CurrencyEvent.Success(
                                "$fromAmount $fromCurrency = $convertedCurrency $toCurrency"
                        )
                    }
                }
            }
        }
    }
```
The next thing I did was the implementation of a navigation menu. I decided to make a bottom navigation bar. For this I created 3 fragments - info, dashboard and settings. From the main activity I've moved everything to the dashboard fragment and from there made 2 intents to other 2 available activities for now (currency converter and expenses). Below is the home fragment.  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Lab3/screens/home.jpg?raw=true)   
Next is the settings fragment(will be configured later):  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Lab3/screens/settings.jpg?raw=true)  
And the info fragment which tells the user what this application is for:  
![alt text](https://github.com/DivineBee/AndroidApp/blob/Lab3/screens/info.jpg?raw=true)  

## Status
_Fixing issues regarding change of API_
