package com.angraankit.www.weather_app.cache

import com.angraankit.www.weather_app.model.Story
import com.angraankit.www.weather_app.model.User
import com.angraankit.www.weather_app.utill.EntityMapper
import javax.inject.Inject

data class StoriesCacheMapper
@Inject constructor(
    var userCacheMapper: UserCacheMapper
) : EntityMapper <StoriesCacheEntity, Story> {
    override fun getEntityFromModel(model: Story): StoriesCacheEntity? {
        return model.id?.let {
            StoriesCacheEntity(
                id = it ,
                title = model.title,
                user = model.user?.let { userCacheMapper.getEntityFromModel(model = it) },
                cover = model.cover
            )
        }
    }

    override fun getModelFromEntity(model: StoriesCacheEntity): Story {
        return Story(
            id = model.id,
            title = model.title,
            user = model.user?.let { userCacheMapper.getModelFromEntity(model = it) },
            cover = model.cover
        )
    }

    fun mapFromEntityList (entities : List<StoriesCacheEntity>) : List <Story> {
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