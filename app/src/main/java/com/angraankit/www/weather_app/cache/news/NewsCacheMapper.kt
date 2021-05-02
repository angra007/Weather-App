package com.angraankit.www.weather_app.cache.news

import com.angraankit.www.weather_app.model.News
import com.angraankit.www.weather_app.model.Story
import com.angraankit.www.weather_app.model.User
import com.angraankit.www.weather_app.network.news.NetworkNews
import com.angraankit.www.weather_app.network.news.NewtorkArticles
import com.angraankit.www.weather_app.utill.EntityMapper
import java.util.*
import javax.inject.Inject

class NewsCacheMapper
@Inject
constructor(

): EntityMapper<NewsCacheEntity, News> {
    override fun getEntityFromModel(model: News): NewsCacheEntity? {
        return NewsCacheEntity(
            id = UUID.randomUUID().toString(),
            title = model.title,
            description = model.description,
            url = model.url
        )
    }

    override fun getModelFromEntity(model: NewsCacheEntity): News {
        return News (
            title = model.title,
            description = model.description,
            url = model.url
        )
    }
}