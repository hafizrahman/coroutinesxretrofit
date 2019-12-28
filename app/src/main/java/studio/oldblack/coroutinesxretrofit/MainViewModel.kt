package studio.oldblack.coroutinesxretrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import studio.oldblack.coroutinesxretrofit.models.Category

class MainViewModel: ViewModel() {
    private val repository: Repository = Repository()

    val fetchedCategories: LiveData<List<Category>> = liveData(Dispatchers.IO) {
        try {
            emit(repository.getCategories())
        } catch(e: Exception) {
            Log.e("Exception happens", "${e.message}")
        }
    }
}