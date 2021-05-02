package com.angraankit.www.weather_app.network

import com.angraankit.www.weather_app.model.Story
import com.angraankit.www.weather_app.model.User
import com.angraankit.www.weather_app.utill.EntityMapper
import javax.inject.Inject

class StoriesNetworkMapper
    @Inject constructor (
        val userNetworkMapper : UserNetworkMapper
    ) : EntityMapper<StorieNetworkEntity, Story>{

    override fun getEntityFromModel(story: Story): StorieNetworkEntity {
        return StorieNetworkEntity(
            id = story.id,
            title = story.title,
            user = story.user?.let { userNetworkMapper.getEntityFromModel(model = it) },
            cover = story.cover
        )
    }

    override fun getModelFromEntity(model: StorieNetworkEntity): Story {
        return Story(
            id = model.id,
            title = model.title,
            user = model.user?.let { userNetworkMapper.getModelFromEntity(model = it) },
            cover = model.cover
        )
    }

    fun mapFromEntityList (entities : StoriesNetworkEntity) : List <Story>? {
        return entities.stories?.map { getModelFromEntity(it) }
    }
}

class UserNetworkMapper
@Inject
constructor() : EntityMapper <UserNetworkEntity, User> {
    override fun getEntityFromModel(model: User): UserNetworkEntity {
        return UserNetworkEntity(
            name = model.name,
            avatar = model.avatar,
            fullname = model.fullname
        )
    }

    override fun getModelFromEntity(model: UserNetworkEntity): User {
        return User(
            name = model.name,
            avatar = model.avatar,
            fullname = model.fullname
        )
    }
}