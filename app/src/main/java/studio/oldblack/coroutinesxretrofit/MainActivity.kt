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
}
