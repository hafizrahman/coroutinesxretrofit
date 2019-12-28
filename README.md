# coroutines x retrofit
This is a quick test project to implement Retrofit using Kotlin's coroutines.

The project is a normal MVVM Android app. The app pulls a list of categories available from freebbble.com, using WordPress's REST API. Specifically, it's calling for http://freebbble.com/wp-json/wp/v2/categories/

Being called using Retrofit, that URL path returns a JSON array of categories. For simplicity sake, the app then picks the first Category and displays its `link` property on the app.

## Screenshot
Here's what the app might show when being run properly:

![Screenshot of couroutinesxretrofit](https://i.imgur.com/32rM6ka.png)

## Resources
 
- ["Suspend what you’re doing: Retrofit has now Coroutines support!"](https://proandroiddev.com/suspend-what-youre-doing-retrofit-has-now-coroutines-support-c65bd09ba067): The bulk of the code is inspired by this tutorial.
- ["Guide to app architecture"](https://developer.android.com/jetpack/docs/guide): General information that includes the MVVM pattern.
- [JSONToKotlinClass](https://github.com/wuseal/JsonToKotlinClass): Android Studio plugin that I used to convert the JSON content to Kotlin data class ("Category" in this code's example).
