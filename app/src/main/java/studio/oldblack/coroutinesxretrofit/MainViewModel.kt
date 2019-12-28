package studio.oldblack.coroutinesxretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import studio.oldblack.coroutinesxretrofit.models.Category

class MainViewModel: ViewModel() {
    private val repository: Repository = Repository()

    val fetchedCategories: LiveData<List<Category>> = liveData(Dispatchers.IO) {
        val data = repository.getCategories()
        emit(data)
    }
}