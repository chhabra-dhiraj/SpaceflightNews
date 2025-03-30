import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleApi
import io.github.chhabra_dhiraj.spaceflightnews.data.repository.ArticleRepositoryImpl
import io.github.chhabra_dhiraj.spaceflightnews.di.AppModule
import io.github.chhabra_dhiraj.spaceflightnews.domain.repository.ArticleRepository
import kotlinx.coroutines.runBlocking

class DummyVM {

    val articleApi: ArticleApi
        get() {
            return AppModule.provideArticleApi()
        }

    val articleRepository: ArticleRepository
        get() {
            return ArticleRepositoryImpl(articleApi)
        }

}

fun main() = runBlocking {
    val vm = DummyVM()
    println(vm.articleApi.getArticle(articleId = 0))
    println(vm.articleRepository.getArticle(articleId = 0))
}