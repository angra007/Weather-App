package com.angraankit.www.weather_app.network.news

import com.angraankit.www.weather_app.model.News
import com.angraankit.www.weather_app.utill.EntityMapper
import org.w3c.dom.Entity
import javax.inject.Inject

class NewsNetworkMapper
@Inject
constructor(

) : EntityMapper<NewtorkArticles, News> {
    override fun getEntityFromModel(model: News): NewtorkArticles? {
        return NewtorkArticles(
            title = model.title,
            description = model.description,
            url = model.url
        )
    }

    override fun getModelFromEntity(model: NewtorkArticles): News {
        return News (
            title = model.title,
            description = model.description,
            url = model.url
        )
    }

    fun mapFromEntityList (entities : NetworkNews) : List <News>? {
        return entities.articles?.map { getModelFromEntity(it) }
    }
}