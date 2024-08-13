package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.chhabra_dhiraj.spaceflightnews.NavigationEvent
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.Resource
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ArticleDetailState())
    val state = _state.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<NavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    // TODO: Check a better way to handle intents
    private val _urlViewIntentEvent = MutableSharedFlow<String>()
    val urlIntentEvent = _urlViewIntentEvent.asSharedFlow()

    init {
        updateStateToLoading()
    }

    private suspend fun loadArticleDetail(articleId: Int) {
        when (val result = repository.getArticle(
            articleId = articleId
        )) {
            is Resource.Success -> {
                _state.update {
                    it.copy(
                        article = result.data,
                        isLoading = false,
                        error = null
                    )
                }
            }

            is Resource.Error -> {
                _state.update {
                    it.copy(
                        article = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

    fun onEvent(event: ArticleDetailEvent) {
        when (event) {
            is ArticleDetailEvent.LoadArticleDetail -> {
                viewModelScope.launch {
                    loadArticleDetail(event.articleId)
                }
            }

            is ArticleDetailEvent.OnViewFullArticleClick -> {
                viewModelScope.launch {
                    _urlViewIntentEvent.emit(event.url)
                }
            }

            ArticleDetailEvent.OnBackButtonClick -> {
                viewModelScope.launch {
                    _navigationEvent.emit(NavigationEvent.NavigateBack)
                }
            }
        }
    }

    private fun updateStateToLoading() {
        _state.update {
            it.copy(
                isLoading = true,
                error = null
            )
        }
    }
}
