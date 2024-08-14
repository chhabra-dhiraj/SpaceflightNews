package io.github.chhabra_dhiraj.spaceflightnews.presentation.articledetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.chhabra_dhiraj.spaceflightnews.NavigationEvent
import io.github.chhabra_dhiraj.spaceflightnews.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.Result
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.asErrorUiText
import kotlinx.coroutines.delay
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

    init {
        updateStateToLoading()
    }

    private suspend fun loadArticleDetail(articleId: Int) {
        when (val result = repository.getArticle(
            articleId = articleId
        )) {
            is Result.Success -> {
                _state.update {
                    it.copy(
                        article = result.data,
                        isLoading = false,
                        error = null
                    )
                }
            }

            is Result.Error -> {
                _state.update {
                    it.copy(
                        article = null,
                        isLoading = false,
                        error = result.asErrorUiText()
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
                    _navigationEvent.emit(NavigationEvent.NavigateToViewFullArticle(event.url))
                }
            }

            ArticleDetailEvent.OnBackButtonClick -> {
                viewModelScope.launch {
                    delay(300L) // For Smooth Transition
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
