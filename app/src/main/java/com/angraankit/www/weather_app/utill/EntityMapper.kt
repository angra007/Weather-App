package com.angraankit.www.weather_app.utill

interface EntityMapper <EntityModel, DomainModel> {

    fun getEntityFromModel (model : DomainModel) : EntityModel?

    fun getModelFromEntity (model: EntityModel) : DomainModel
}