package io.github.chhabra_dhiraj.spaceflightnews.feature.article.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.repository.ArticleRepositoryImpl
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindArticleRepository(
        articleRepositoryImpl: ArticleRepositoryImpl
    ): ArticleRepository
}