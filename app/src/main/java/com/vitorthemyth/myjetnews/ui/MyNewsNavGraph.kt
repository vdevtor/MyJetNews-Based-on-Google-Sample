package com.vitorthemyth.myjetnews.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.vitorthemyth.myjetnews.MyNewsApplication.Companion.JETNEWS_APP_URI
import com.vitorthemyth.myjetnews.data.AppContainer
import com.vitorthemyth.myjetnews.ui.home.HomeViewModel

const val POST_ID = "postId"

@Composable
fun JetnewsNavGraph(
        appContainer: AppContainer,
        isExpandedScreen: Boolean,
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController(),
        openDrawer: () -> Unit = {},
        startDestination: String = MyNewsDestinations.HOME_ROUTE,
) {
    NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
    ) {
        composable(
                route = MyNewsDestinations.HOME_ROUTE,
                deepLinks = listOf(
                        navDeepLink {
                            uriPattern =
                                    "$JETNEWS_APP_URI/${MyNewsDestinations.HOME_ROUTE}?$POST_ID={$POST_ID}"
                        }
                )
        ) { navBackStackEntry ->
            val homeViewModel: HomeViewModel = viewModel(
                    factory = HomeViewModel.provideFactory(
                            postsRepository = appContainer.postsRepository,
                            preSelectedPostId = navBackStackEntry.arguments?.getString(POST_ID)
                    )
            )

//            HomeRoute(
//                    homeViewModel = homeViewModel,
//                    isExpandedScreen = isExpandedScreen,
//                    openDrawer = openDrawer,
//            )
        }
//        composable(MyNewsDestinations.INTERESTS_ROUTE) {
//            val interestsViewModel: InterestsViewModel = viewModel(
//                    factory = InterestsViewModel.provideFactory(appContainer.interestsRepository)
//            )
//            InterestsRoute(
//                    interestsViewModel = interestsViewModel,
//                    isExpandedScreen = isExpandedScreen,
//                    openDrawer = openDrawer
//            )
//        }
    }
}
