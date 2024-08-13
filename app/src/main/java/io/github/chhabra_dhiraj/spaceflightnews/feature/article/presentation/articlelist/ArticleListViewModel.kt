package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
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

    init {
        loadArticleList()
    }

    private fun loadArticleList() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }
            when (val result = repository.getArticleList()) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            articles = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                }

                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            articles = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: ArticleListEvent) {
        when (event) {
            is ArticleListEvent.OnArticleClick -> {
                viewModelScope.launch {
                    // TODO
                }
            }

            ArticleListEvent.OnRefreshArticleList -> {
                viewModelScope.launch {
                    loadArticleList()
                }
            }
        }
    }
}