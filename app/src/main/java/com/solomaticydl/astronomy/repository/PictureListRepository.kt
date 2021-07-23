package com.solomaticydl.astronomy.repository

import com.solomaticydl.astronomy.datasource.PictureListDataSource
import com.solomaticydl.astronomy.model.AstronomyModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

class PictureListRepository(
    private val pictureListDataSource: PictureListDataSource = PictureListDataSource()
) {

    @ExperimentalCoroutinesApi
    suspend fun getAstronomyData(): List<AstronomyModel> {
        return pictureListDataSource.getData()
    }

    fun cancel() {
        pictureListDataSource.cancel()
    }
}