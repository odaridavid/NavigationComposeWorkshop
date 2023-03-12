package dev.davidodari.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import dev.davidodari.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen {
                                navController.navigate("details/This should work when we navigate")
                            }
                        }
                        composable(
                            route = "details?descriptionText = {descriptionText}",
                            arguments = listOf(
                                navArgument("descriptionText") {
                                    type = NavType.StringType
                                    defaultValue = "Default Value Used"
                                }
                            ),
                            deepLinks = listOf(navDeepLink {
                                uriPattern = "navigation://details?{descriptionText}"
                            })
                        ) { backStackEntry ->
                            val descriptionText =
                                backStackEntry.arguments?.getString("descriptionText")
                                    ?: stringResource(
                                        id = R.string.details_screen_text
                                    )

                            DetailsScreen(descriptionText = descriptionText) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}
