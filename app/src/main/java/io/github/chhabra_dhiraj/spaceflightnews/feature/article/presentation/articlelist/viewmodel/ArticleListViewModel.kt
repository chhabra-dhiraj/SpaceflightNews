package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.Resource
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.state.ArticleListState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    var state by mutableStateOf(ArticleListState())
        private set

    fun loadArticleList() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when (val result = repository.getArticles()) {
                is Resource.Success -> {
                    state = state.copy(
                        articles = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        articles = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}