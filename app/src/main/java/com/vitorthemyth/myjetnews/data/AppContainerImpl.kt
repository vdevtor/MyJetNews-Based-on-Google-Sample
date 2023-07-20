package com.vitorthemyth.myjetnews.data

import android.content.Context
import com.vitorthemyth.myjetnews.data.interests.InterestsRepository
import com.vitorthemyth.myjetnews.data.interests.imp.FakeInterestsRepository
import com.vitorthemyth.myjetnews.data.posts.PostsRepository
import com.vitorthemyth.myjetnews.data.posts.imp.FakePostsRepository

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val postsRepository: PostsRepository
    val interestsRepository: InterestsRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PostsRepository by lazy {
        FakePostsRepository()
    }

    override val interestsRepository: InterestsRepository by lazy {
        FakeInterestsRepository()
    }
}