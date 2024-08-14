package io.github.chhabra_dhiraj.spaceflightnews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.chhabra_dhiraj.spaceflightnews.presentation.articledetail.BaseArticleDetailScreen
import io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist.BaseArticleListScreen
import kotlinx.serialization.Serializable

@Immutable
sealed class NavigationEvent {
    data class NavigateToArticle(val articleId: Int) : NavigationEvent()
    data class NavigateToViewFullArticle(val url: String) : NavigationEvent()
    object NavigateBack : NavigationEvent()
}

// Routes
@Serializable
object ArticleList

@Serializable
data class ArticleDetail(val articleId: Int)

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ArticleList
    ) {
        composable<ArticleList> {
            BaseArticleListScreen(navController = navController)
        }
        composable<ArticleDetail> {
            BaseArticleDetailScreen(
                navBackStackEntry = it,
                navController = navController
            )
        }
    }
}