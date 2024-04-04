package org.d3if3030.jurnal_sysprog.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3030.jurnal_sysprog.R
import org.d3if3030.jurnal_sysprog.ui.theme.Jurnal_sysprogTheme
import org.d3if3030.model.Book
import org.d3if3030.model.Journal
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import org.d3if3030.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navHostController: NavHostController) {
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                      navHostController.navigate(Screen.UpdateJurnal.route)
                },
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp),
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(text = stringResource(id = R.string.app_name))
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navHostController.navigate(Screen.UpdateJurnal.route) }) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) {
        ScreenContent(Modifier.padding(it))
    }
}

@Composable
fun ScreenContent(modifier: Modifier) {
    var bookTitle = "The Rust Programming Language"
    var data = MainViewModel.data

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.the_rust_programming_language),
                contentDescription = stringResource(id = R.string.picture, bookTitle),
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(132.dp)
            )
        }
        item {
            Text(
                text = bookTitle,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        items(data) {
            ListJournal(journal = it)
            Divider()
        }
    }
}




@Composable
fun ListJournal(journal: Journal) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = journal.chapter,
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = "understand: " + journal.understand,
            style = MaterialTheme.typography.bodySmall.copy(color = Color.Red)
        )
        Text(
            text = journal.jurnal,
            style = MaterialTheme.typography.bodySmall,
        )
    }

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    Jurnal_sysprogTheme {
        MainScreen(rememberNavController())
    }
}