package studio.oldblack.coroutinesxretrofit

class Repository {
    var client = CategoryService.create()

    suspend fun getCategories() = client.getCategories()
}