package com.example.dailyforecast.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dailyforecast.R

@Composable
fun HomeScreen(){

    val viewModel = hiltViewModel<HomeViewModel>()
    val state = viewModel.state.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
                    .padding(it)
                    .background(MaterialTheme.colorScheme.background)
                    .imePadding()
            ) {
                CityDropDownMenu(state = state.value, listener = viewModel)
                if (state.value.isError) ErrorAndRetry(listener = viewModel)
                LazyColumn(
                    modifier = Modifier
                        .semantics { contentDescription = "weatherList" }
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 4.dp
                    )
                ) {
                    if (state.value.isLoading) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(440.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    } else {
                        itemsIndexed(items = state.value.weatherItems) { index, user ->
                            WeatherItem(user, index = index)
                        }
                    }
                }
            }
            SnackBar(
                icon = painterResource(R.drawable.ic_android),
                isVisible = state.value.showSnackBar,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = stringResource(R.string.it_s_not_accurate_data),
                    style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.background
                )
            }

        }
    }
}

