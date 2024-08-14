package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.chhabra_dhiraj.spaceflightnews.NavigationEvent
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.util.network.Result
import io.github.chhabra_dhiraj.spaceflightnews.util.error.getErrorRes
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ArticleListState())
    val state = _state.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<NavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    init {
        viewModelScope.launch {
            updateStateToLoading()
            loadArticleList()
        }
    }


    private suspend fun loadArticleList() {
        when (val result = repository.getArticleList()) {
            is Result.Success -> {
                _state.update {
                    it.copy(
                        articles = result.data,
                        isLoading = false,
                        errorRes = null
                    )
                }
            }

            is Result.Error -> {
                _state.update {
                    it.copy(
                        articles = null,
                        isLoading = false,
                        errorRes = result.error.getErrorRes()
                    )
                }
            }
        }
    }

    fun onEvent(event: ArticleListEvent) {
        when (event) {
            is ArticleListEvent.OnArticleClick -> {
                viewModelScope.launch {
                    _navigationEvent.emit(
                        NavigationEvent.NavigateToArticle(
                            articleId = event.articleId
                        )
                    )
                }
            }

            ArticleListEvent.OnRefreshArticleList -> {
                viewModelScope.launch {
                    updateStateToLoading()
                    loadArticleList()
                }
            }
        }
    }

    private fun updateStateToLoading() {
        _state.update {
            it.copy(
                isLoading = true,
                errorRes = null
            )
        }
    }
}
