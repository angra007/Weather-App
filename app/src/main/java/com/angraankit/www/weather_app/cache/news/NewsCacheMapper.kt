package com.angraankit.www.weather_app.cache.news

import com.angraankit.www.weather_app.model.Story
import com.angraankit.www.weather_app.model.User
import com.angraankit.www.weather_app.utill.EntityMapper
import javax.inject.Inject

data class NewsCacheMapper
@Inject constructor(
    var userCacheMapper: UserCacheMapper
) : EntityMapper <NewsCacheEntity, Story> {
    override fun getEntityFromModel(model: Story): NewsCacheEntity? {
        return model.id?.let {
            NewsCacheEntity(
                id = it,
                title = model.title,
                user = model.user?.let { userCacheMapper.getEntityFromModel(model = it) },
                cover = model.cover
            )
        }
    }

    override fun getModelFromEntity(model: NewsCacheEntity): Story {
        return Story(
            id = model.id,
            title = model.title,
            user = model.user?.let { userCacheMapper.getModelFromEntity(model = it) },
            cover = model.cover
        )
    }

    fun mapFromEntityList (entities : List<NewsCacheEntity>) : List <Story> {
        return entities.map { getModelFromEntity(it) }
    }
}

class UserCacheMapper
@Inject
constructor() : EntityMapper <UserCacheEntity, User> {

    override fun getEntityFromModel(model: User): UserCacheEntity {
        return UserCacheEntity(
            name = model.name ?: "",
            avatar = model.avatar,
            fullname = model.fullname
        )
    }

    override fun getModelFromEntity(model: UserCacheEntity): User {
        return User(
            name = model.name,
            avatar = model.avatar,
            fullname = model.fullname
        )
    }
}