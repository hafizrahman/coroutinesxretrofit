package studio.oldblack.coroutinesxretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        /*
           This is a test app to try coroutines with Retrofit.
           ---------------------------------------------------------------------------------
           It will be an MVVM app using ViewModel and Repository, accessing the content
           of http://freebbble.com/wp-json/wp/v2/categories/ with Retrofit and then
           displaying the content on the main app.
           The model for the data is available in models/Category.kt , while the example
           JSON output for the URL above is shown in the example.json file in models/ .
         */
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        displaySomething()
    }

    private fun displaySomething() {
        viewModel.fetchedCategories.observe(this, Observer {

            // By default, the JSON returns an array of Category.
            // Here we are displaying the "link" property of the first Category.
            texttext.text = it[0].link
        })
    }

    override fun onStop() {
        super.onStop()

        /*
        This overriden function is only here for educational purposes.

        Here we don't really need to remove the observer created in displaySomething(),
        because according to documentation:

        "An observer added with a Lifecycle will be automatically removed if the corresponding
         Lifecycle moves to Lifecycle.State.DESTROYED state. This is especially useful for
         activities and fragments where they can safely observe LiveData and not worry about
         leaks: they will be instantly unsubscribed when they are destroyed."

         (https://developer.android.com/reference/androidx/lifecycle/LiveData.html)

         If we were using some other libraries, we might need to be unregistering things here.
         */
    }
}
