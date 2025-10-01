package com.example.mycity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.mycity.ui.CategoryListScreen
import com.example.mycity.ui.MyCityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.LocationDetail
import com.example.mycity.ui.LocationListScreen


enum class MyCityScreen (titleID:Int) {
    ChooseCategory(R.string.screen_title_chooseCategoty),
    ChooseLocation(R.string.screen_title_chooseLocation),
    LocationDetail(R.string.screen_title_locationDetail)
}

@Composable
fun MyCityApp() {
    val viewModel: MyCityViewModel = viewModel()
    val navController: NavHostController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.ChooseCategory.name
    )

    val uiState by viewModel.uiState.collectAsState()

    val topTitle = if(currentScreen == MyCityScreen.LocationDetail) {
        stringResource(uiState.chosenLocation.nameResId)
    } else {
        currentScreen.name
    }

    Scaffold(
        topBar = {
            AppBar(
                onBackButtonClick = { navController.popBackStack() },
                isShowingBackButton =navController.previousBackStackEntry != null ,
                title = topTitle,
                modifier = Modifier
            )
        }
    ) { innerPadding ->


        NavHost(
            navController= navController,
            startDestination = MyCityScreen.ChooseCategory.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = MyCityScreen.ChooseCategory.name){
                CategoryListScreen(
                    onCategoryClick = { category ->
                        viewModel.updateChosenCategory(category)
                        navController.navigate(MyCityScreen.ChooseLocation.name)
                    }
                )
            }

            composable(route = MyCityScreen.ChooseLocation.name){
                LocationListScreen(
                    category = uiState.chosenCategory,
                    onLocationClick ={ location ->
                        viewModel.updateChosenLocation(location)
                        navController.navigate(MyCityScreen.LocationDetail.name)

                    }
                )
            }

            composable(route = MyCityScreen.LocationDetail.name) {
                LocationDetail(location = uiState.chosenLocation)
            }


        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    onBackButtonClick: () -> Unit,
    isShowingBackButton: Boolean,
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        navigationIcon = if (isShowingBackButton) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            }
        } else {
            { Box {} }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
    )
}
